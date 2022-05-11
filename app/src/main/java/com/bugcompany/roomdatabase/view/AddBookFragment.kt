package com.bugcompany.roomdatabase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bugcompany.roomdatabase.R
import com.bugcompany.roomdatabase.databinding.FragmentAddBookBinding
import com.bugcompany.roomdatabase.room.BookDatabase
import com.bugcompany.roomdatabase.room.BookModel


class AddBookFragment : Fragment() {
    private lateinit var bookDb:BookDatabase
    private lateinit var binding: FragmentAddBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bookDb= BookDatabase.getBookDatabase(requireContext())!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddBookBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            addBookButton.setOnClickListener {
                val bookName=editTextBookName.text.toString()
                val authorName=editTextAuthorName.text.toString()

                if(bookName!=""&&authorName!=""){
                    bookDb.bookDao().addBook(BookModel(book_name = bookName, author_name = authorName))
                    findNavController().navigate(R.id.action_addBookFragment_to_homeFragment)
                }
            }
        }
    }
}