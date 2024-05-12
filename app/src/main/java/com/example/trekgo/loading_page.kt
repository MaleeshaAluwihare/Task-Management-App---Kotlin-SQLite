package com.example.trekgo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class loading_page:  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_page);

        android.os.Handler().postDelayed({
            val intent = Intent(this, first_onboard_page::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}