package com.example.ebookapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM book_table ORDER BY title ASC")
    fun getBooksAlphabetically(): LiveData<List<Book>>

    @Insert
    suspend fun insertBook(book: Book)

    @Query("SELECT * FROM book_table WHERE title = :title")
    fun getBookByTitle(title: String): LiveData<Book>

}
