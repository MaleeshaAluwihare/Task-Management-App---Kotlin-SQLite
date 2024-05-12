package com.example.trekgo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class settings_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings);

        val addTaskActivity : View  = findViewById(R.id.AddTaskBtn);
        val home: View = findViewById(R.id.imageView3);

        addTaskActivity.setOnClickListener {
            val intent = Intent(this,AddTaskActivity::class.java);
            startActivity(intent);
        }

        home.setOnClickListener {
            val intent = Intent(this,home::class.java);
            startActivity(intent);
        }
    }
}
