package com.bugcompany.roomdatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugcompany.roomdatabase.databinding.ItemCardBinding
import com.bugcompany.roomdatabase.room.BookModel

class Adapter(val mContext: Context, val bookList: List<BookModel>) :
    RecyclerView.Adapter<Adapter.ItemCard>() {

    inner class ItemCard(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCard {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ItemCard(binding)
    }

    override fun onBindViewHolder(holder: ItemCard, position: Int) {
        val book = bookList[position]
        holder.binding.textViewBookName.text = book.book_name
        holder.binding.textViewAuthorName.text = book.author_name

    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}