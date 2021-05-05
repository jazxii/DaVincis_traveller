package com.example.wanderlust

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    lateinit var mDatabase : DatabaseReference
    var mAuth = FirebaseAuth.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        mDatabase = FirebaseDatabase.getInstance().getReference("Names")

        val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val nameee = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            val uid = user.uid
        }
        val resultTextView: TextView = findViewById(R.id.textView3)
        resultTextView.text =user.displayName


        val nameTxt = findViewById<View>(R.id.textView12) as TextView

        var uid = user!!.uid

        mDatabase = FirebaseDatabase.getInstance().getReference("users/$uid/name")

        mDatabase.child(uid).child("users/$uid/Name").addValueEventListener( object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                nameTxt.text =  snapshot.value.toString()
            }
        })

        val no = intent.getStringExtra("num")
        val r3: TextView = findViewById(R.id.textView13)
        r3.text=no


        val resultTextView2: TextView = findViewById(R.id.textView10)
        resultTextView2.text =user.email

        val nam = intent.getStringExtra("nameo")
        val r2:TextView =findViewById(R.id.textView6)
        r2.text=nam

        val pl: Button= findViewById(R.id.plan)
        pl.setOnClickListener {
            val intent = Intent(this, qstns::class.java)
            startActivity(intent)
        }

        val signor: Button= findViewById(R.id.signout)
        signor.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }


    }
}