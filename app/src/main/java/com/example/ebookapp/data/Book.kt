package com.example.ebookapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String,
    val genre: String,
    val isbn: Long,
    val pages: Int,
    val price: String,
    val publicationYear: Int,
    val series: String,
    val seriesNum: Int,
    val title: String
)
