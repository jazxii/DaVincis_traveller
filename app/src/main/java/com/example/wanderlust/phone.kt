package com.example.wanderlust

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class phone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        supportActionBar?.hide()
        val snd:Button=(findViewById(R.id.snd))
        val mobileNumber: EditText= findViewById(R.id.mobileNumber)

        snd.setOnClickListener {

            if (mobileNumber.text.count() == 10) {
                val i = Intent(this, phone2::class.java).apply {
                    putExtra("mobileNumber", mobileNumber.text.toString())
                }
                startActivity(i)
            } else {
                Toast.makeText(this, "Enter 10 digits mobile number",Toast.LENGTH_LONG).show()
            }
        }
    }
}

