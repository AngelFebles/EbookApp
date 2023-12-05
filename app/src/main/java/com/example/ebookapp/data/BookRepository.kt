package com.example.ebookapp.data

import androidx.lifecycle.LiveData

class BookRepository(private val bookDao: BookDao) {

    suspend fun insertBook(book: Book) {
        bookDao.insertBook(book)
    }

    fun getBooksAlphabetically(): LiveData<List<Book>> {
        return bookDao.getBooksAlphabetically()
    }

    fun getBookByTitle(title: String): LiveData<Book> {
        return bookDao.getBookByTitle(title)
    }
}