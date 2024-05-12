package com.example.trekgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class first_onboard_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_onboard_page);

        val button: Button = findViewById(R.id.firstButton);

        button.setOnClickListener {
            val intent = Intent(this, second_onboard_page::class.java);
            startActivity(intent);
        }
    }
}