package com.example.ebookapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ebookapp.library.LibraryActivity

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createaccount)

        val createButton = findViewById<Button>(R.id.create)

        createButton.setOnClickListener {
            val intent = Intent(this@CreateAccountActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}