package com.example.ebookapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.widget.SearchView
import android.widget.ImageView
import com.squareup.picasso.Picasso
import android.widget.TextView


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val searchView = findViewById<SearchView>(R.id.searchView)
        val bookCoverImageView = findViewById<ImageView>(R.id.bookCoverImageView)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val authorTextView = findViewById<TextView>(R.id.authorTextView)
        val genreTextView = findViewById<TextView>(R.id.genreTextView)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        val book = getBookDetailsFromDatabase()

        Picasso.get().load(book.cover).into(bookCoverImageView)

        // Set other book details
        titleTextView.text = book.title
        authorTextView.text = book.author
        genreTextView.text = book.genre
    }

    private fun getBookDetailsFromDatabase(): Book {
        // temp book info
        return Book(
            title = "The Two Towers (Lord of the Rings Part 2)",
            author = "J.R.R. Tolkien",
            genre = "Fantasy",
            cover = "https://prodimage.images-bn.com/lf?set=key%5Bresolve.pixelRatio%5D,value%5B1%5D&set=key%5Bresolve.width%5D,value%5B600%5D&set=key%5Bresolve.height%5D,value%5B10000%5D&set=key%5Bresolve.imageFit%5D,value%5Bcontainerwidth%5D&set=key%5Bresolve.allowImageUpscaling%5D,value%5B0%5D&set=key%5Bresolve.format%5D,value%5Bwebp%5D&source=url%5Bhttps://prodimage.images-bn.com/pimages/9780547928203_p0_v4_s600x595.jpg%5D&scale=options%5Blimit%5D,size%5B600x10000%5D&sink=format%5Bwebp%5D"
        )
    }
}

data class Book(
    val title: String,
    val author: String,
    val genre: String,
    val cover: String
)
