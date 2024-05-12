package com.example.trekgo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trekgo.databinding.ActivityTaskUpdateBinding

class TaskUpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskUpdateBinding
    private lateinit var db: TasksDatabase
    private var taskId:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabase(this)

        taskId = intent.getIntExtra("task_id",-1)
        if(taskId == -1){
            finish()
            return
        }

        val task = db.getTaskById(taskId)
        binding.updateTextName.setText(task.name)
        binding.updateTextDate.setText(task.date)
        binding.updateTextTime.setText(task.time)
        binding.updateTextDescription.setText(task.description)

        binding.updateTaskBtn.setOnClickListener{
            val newName = binding.updateTextName.text.toString()
            val newDate = binding.updateTextDate.text.toString()
            val newTime = binding.updateTextTime.text.toString()
            val newDescription = binding.updateTextDescription.text.toString()
            val updateTask = Task(taskId,newName,newDate,newTime,newDescription)
            db.updateTask(updateTask)
            finish()
            Toast.makeText(this,"Task Updated",Toast.LENGTH_SHORT).show()
        }
    }
}