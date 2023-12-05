package com.example.ebookapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
    val readAllData: LiveData<List<Book>>

    init {
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        repository = BookRepository(bookDao)
        readAllData = repository.getBooksAlphabetically()
    }

    fun addBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertBook(book)
        }
    }

    fun getBookByTitle(title: String): LiveData<Book> {
        return repository.getBookByTitle(title)
    }

    private val cartItems: MutableList<Book> = mutableListOf()
    // Function to add a book to the cart
    fun addToCart(book: Book) {
        cartItems.add(book)
    }

    // Function to get the list of items in the cart
    fun getCartItems(): List<Book> {
        return cartItems.toList()
    }

}
