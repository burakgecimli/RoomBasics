package com.bugcompany.roomdatabase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bugcompany.roomdatabase.adapter.Adapter
import com.bugcompany.roomdatabase.R
import com.bugcompany.roomdatabase.databinding.FragmentHomeBinding
import com.bugcompany.roomdatabase.room.BookDatabase
import com.bugcompany.roomdatabase.room.BookModel
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bookDb:BookDatabase
    private lateinit var bookList:List<BookModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookDb= BookDatabase.getBookDatabase(requireContext())!!
        bookList= bookDb.bookDao().getAllBook()!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showAllBook()
        binding.apply {
            buttonNewBook.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_addBookFragment)
            }
        }
    }

    fun showAllBook(){
        binding.apply {
            if (bookList.isEmpty()){
                Snackbar.make(requireView(),"Kitap Bulunamadı",1000).show()
            }else{
                val adapter= Adapter(requireContext(),bookList)
                rvBook.adapter=adapter
                rvBook.layoutManager= GridLayoutManager(context, 2)
                rvBook.setHasFixedSize(true)
            }
        }
    }
}