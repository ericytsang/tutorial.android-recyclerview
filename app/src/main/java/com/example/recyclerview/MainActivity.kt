package com.example.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class MainActivity:AppCompatActivity()
{
    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerview_quotes) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter()
    }

    inner class CustomAdapter:RecyclerView.Adapter<QuoteViewHolder>()
    {
        private val quotes = resources.getStringArray(R.array.quotes)

        override fun onBindViewHolder(holder:QuoteViewHolder,position:Int)
        {
            holder.model = quotes[position]
        }

        override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):QuoteViewHolder
        {
            return QuoteViewHolder.new(parent)
        }

        override fun getItemCount():Int
        {
            return quotes.size
        }
    }
}
