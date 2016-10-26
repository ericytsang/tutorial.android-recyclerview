package com.example.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import java.util.Collections

class MainActivity:AppCompatActivity()
{
    lateinit var recyclerViewAdapter:CustomAdapter

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewAdapter = CustomAdapter()

        val recyclerView:RecyclerView = findViewById(R.id.recyclerview_quotes) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerViewAdapter
    }

    override fun onCreateOptionsMenu(menu:Menu?):Boolean
    {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item:MenuItem):Boolean
    {
        return when (item.itemId)
        {
            R.id.action_add ->
            {
                recyclerViewAdapter.addRandom()
                true
            }
            R.id.action_remove ->
            {
                recyclerViewAdapter.removeRandom()
                true
            }
            R.id.action_shuffle ->
            {
                recyclerViewAdapter.shuffleExisting()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    inner class CustomAdapter:RecyclerView.Adapter<QuoteViewHolder>()
    {
        private val quotePool = resources.getStringArray(R.array.quotes)

        private val quotes:MutableList<String> = mutableListOf()

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

        fun addRandom()
        {
            val listIndex:Int = quotes.indices.maxBy {Math.random()} ?: 0
            val quote = quotePool.maxBy {Math.random()}!!
            quotes.add(listIndex,quote)
            notifyDataSetChanged()
        }

        fun shuffleExisting()
        {
            Collections.shuffle(quotes)
            notifyDataSetChanged()
        }

        fun removeRandom()
        {
            if (quotes.isNotEmpty())
            {
                val listIndex:Int = quotes.indices.maxBy {Math.random()} ?: 0
                quotes.removeAt(listIndex)
                notifyDataSetChanged()
            }
        }
    }
}
