package com.example.trekgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.trekgo.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db: TasksDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homePage: View = findViewById(R.id.imageView16)
        val settingPage: View = findViewById(R.id.imageView8)
        val homePageIcon: View = findViewById(R.id.imageView3)

        homePage.setOnClickListener{
            val intent = Intent(this,home::class.java);
            startActivity(intent);
        }
        settingPage.setOnClickListener{
            val intent = Intent(this,settings_page::class.java);
            startActivity(intent);
        }
        homePageIcon.setOnClickListener{
            val intent = Intent(this,home::class.java);
            startActivity(intent);
        }


        db = TasksDatabase(this)

        binding.createTask.setOnClickListener{
            val name = binding.editTextName.text.toString()
            val date = binding.editTextDate.text.toString()
            val time = binding.editTextTime.text.toString()
            val description = binding.editTextDescription.text.toString()
            val task = Task(0,name,date,time,description)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Saved",Toast.LENGTH_SHORT).show()
        }
    }
}