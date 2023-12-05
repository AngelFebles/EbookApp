package com.example.ebookapp.library

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.ebookapp.HomeActivity
import com.example.ebookapp.R
import com.example.ebookapp.cart.CartActivity

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val homeButton = findViewById<ImageButton>(R.id.homeButton)

        homeButton.setOnClickListener {
            val intent = Intent(this@LibraryActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        val cartButton = findViewById<ImageButton>(R.id.cartButton)

        cartButton.setOnClickListener {
            val intent = Intent(this@LibraryActivity, CartActivity::class.java)
            startActivity(intent)
        }
    }
}