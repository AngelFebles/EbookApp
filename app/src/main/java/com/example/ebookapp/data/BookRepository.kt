package com.example.ebookapp.data

import androidx.lifecycle.LiveData

class BookRepository(private val bookDao: BookDao) {

    val readALlData: LiveData<List<Book>> = bookDao.getBooksAlphabetically()

    suspend fun addBook(book: Book){
        bookDao.insertBook(book)
    }

    fun getBookByTitle(title: String): LiveData<Book> {
        return bookDao.getBookByTitle(title)
    }
}

