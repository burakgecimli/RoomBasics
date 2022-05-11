package com.bugcompany.roomdatabase.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookcase")
data class BookModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0,

    @ColumnInfo(name = "book_name")
    var book_name: String,

    @ColumnInfo(name = "author_name")
    var author_name: String
) {

}