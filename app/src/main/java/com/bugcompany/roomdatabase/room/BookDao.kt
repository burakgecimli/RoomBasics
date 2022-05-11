package com.bugcompany.roomdatabase.room

import androidx.room.*

@Dao
interface BookDao {

    @Insert
    fun addBook(bookModel:BookModel)

    @Update
    fun updateBook(bookModel:BookModel)

    @Delete
    fun deleteBook(bookModel:BookModel)

    @Query("SELECT *FROM bookcase")
    fun getAllBook():List<BookModel>
}