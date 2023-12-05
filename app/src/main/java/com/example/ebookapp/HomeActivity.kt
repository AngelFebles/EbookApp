package com.example.ebookapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ebookapp.cart.CartActivity
import com.example.ebookapp.data.Book
import com.example.ebookapp.data.UserViewModel
import com.example.ebookapp.library.LibraryActivity


class HomeActivity : AppCompatActivity() {

    private var userViewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val book1 = Book(
            0,
            "J.R.R. Tolkien",
            "Fantasy",
            9780547928210L,
            432,
            "$17.99",
            2012,
            "The Lord of the Rings",
            1,
            "The Fellowship of the Ring (The Lord of the Rings, Part 1)"
        )

        val book2 = Book(
            1,
            "J.R.R. Tolkien",
            "Fantasy",
            9780547928203,
            352,
            "$17.99",
            2012,
            "The Lord of the Rings",
            1,
            "The Two Towers (Lord of the Rings Part 2)"
        )

        val libraryButton = findViewById<ImageButton>(R.id.libraryButton)

        libraryButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, LibraryActivity::class.java)
            startActivity(intent)
        }

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        updateUI(book1, book2)

        val cartButton = findViewById<ImageButton>(R.id.cartButton)

        cartButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, CartActivity::class.java)
            startActivity(intent)
        }

        val addToCartButton = findViewById<Button>(R.id.addToCartButton)
        val addToCartButton2 = findViewById<Button>(R.id.addToCartButton2)

        addToCartButton.setOnClickListener {
            addToCart(book1)
        }

        addToCartButton2.setOnClickListener {
            addToCart(book2)
        }
    }

    private fun updateUI(book1: Book, book2: Book) {
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val authorTextView = findViewById<TextView>(R.id.authorTextView)
        val genreTextView = findViewById<TextView>(R.id.genreTextView)
        titleTextView.text = "Title: " + book1.title
        authorTextView.text = "Author: " + book1.author
        genreTextView.text = "Genre: " + book1.genre

        val titleTextView2 = findViewById<TextView>(R.id.titleTextView2)
        val authorTextView2 = findViewById<TextView>(R.id.authorTextView2)
        val genreTextView2 = findViewById<TextView>(R.id.genreTextView2)
        titleTextView2.text = "Title: " + book2.title
        authorTextView2.text = "Author: " + book2.author
        genreTextView2.text = "Genre: " + book2.genre
    }

    private fun addToCart(book: Book) {
        userViewModel?.addToCart(book)
    }
}
