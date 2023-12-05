package com.example.ebookapp.cart

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.ebookapp.HomeActivity
import com.example.ebookapp.R
import com.example.ebookapp.library.LibraryActivity

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val homeButton = findViewById<ImageButton>(R.id.homeButton)

        homeButton.setOnClickListener {
            val intent = Intent(this@CartActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        val libraryButton = findViewById<ImageButton>(R.id.libraryButton)

        libraryButton.setOnClickListener {
            val intent = Intent(this@CartActivity, LibraryActivity::class.java)
            startActivity(intent)
        }

    }
}
