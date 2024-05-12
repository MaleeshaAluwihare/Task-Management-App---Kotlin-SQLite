package com.example.trekgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trekgo.databinding.ActivityTaskPageBinding

class TaskPageActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTaskPageBinding
    private lateinit var db: TasksDatabase
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabase(this)
        taskAdapter = TaskAdapter(db.getAllTasks(),this)

        binding.TaskRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.TaskRecyclerView.adapter = taskAdapter

        binding.AddTaskBtn.setOnClickListener {
            val intent = Intent(this,AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        taskAdapter.refreshData(db.getAllTasks())
    }
}