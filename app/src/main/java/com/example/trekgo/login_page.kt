package com.example.trekgo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class login_page: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page);

        val button: Button = findViewById(R.id.button);

        button.setOnClickListener {
            val intent = Intent(this, home::class.java);
            startActivity(intent);
        }
    }
}