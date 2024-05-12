package com.example.trekgo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class second_onboard_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_onboard_page);

        val button: Button = findViewById(R.id.button2);

        button.setOnClickListener {
            val intent = Intent(this, login_page::class.java);
            startActivity(intent);
        }
    }
}