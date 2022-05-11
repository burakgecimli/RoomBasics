package com.bugcompany.roomdatabase.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BookModel::class], version = 1)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        private var INSTANCE: BookDatabase? = null

        fun getBookDatabase(context: Context): BookDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, BookDatabase::class.java, "books.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}