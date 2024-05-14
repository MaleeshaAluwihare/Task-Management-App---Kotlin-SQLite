package com.example.trekgo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class home: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home);

        val button: Button = findViewById(R.id.button3);
        val addTask: View = findViewById(R.id.AddTaskBtn)
        val profile: View = findViewById(R.id.imageView8)
        val setting: View = findViewById(R.id.imageView)


        button.setOnClickListener {
            val intent = Intent(this, TaskPageActivity::class.java);
            startActivity(intent);
        }

        addTask.setOnClickListener{
            val intent = Intent(this, AddTaskActivity::class.java);
            startActivity(intent);
        }

        profile.setOnClickListener{
            val intent = Intent(this,settings_page::class.java);
            startActivity(intent);
        }

        setting.setOnClickListener{
            val intent = Intent(this,settings_page::class.java);
            startActivity(intent);
        }
    }
}