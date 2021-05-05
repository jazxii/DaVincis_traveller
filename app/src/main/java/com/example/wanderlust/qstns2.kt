package com.example.wanderlust

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class qstns2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qstns2)
        supportActionBar?.hide()



        val nxt2 : Button = findViewById(R.id.nxt2)
        nxt2.setOnClickListener {
            val intent= Intent(this, home::class.java)
            startActivity(intent)
        }





    }
}