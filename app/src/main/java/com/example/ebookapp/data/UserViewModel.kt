package com.example.ebookapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Book>>
    private val repository: BookRepository

    init{
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        repository = BookRepository(bookDao)
        readAllData = repository.readALlData
    }

    fun addBook(book: Book){
        viewModelScope.launch(Dispatchers.IO){
            repository.addBook(book)
        }
    }

    fun getBookByTitle(title: String): LiveData<Book> {
        return repository.getBookByTitle(title)
    }
}
