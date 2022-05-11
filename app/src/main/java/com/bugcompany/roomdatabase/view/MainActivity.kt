package com.bugcompany.roomdatabase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bugcompany.roomdatabase.databinding.ActivityMainBinding
import com.bugcompany.roomdatabase.room.BookDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var bookDb:BookDatabase
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookDb= BookDatabase.getBookDatabase(this)!!
    }
}