package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class QuoteViewHolder private constructor(view:View):ViewHolder<String>(view)
{
    companion object
    {
        fun new(parent:ViewGroup):QuoteViewHolder
        {
            val viewInflater = LayoutInflater.from(parent.context)
            val quoteListItemView = viewInflater.inflate(R.layout.listitem_quote,parent,false)
            return QuoteViewHolder(quoteListItemView)
        }
    }

    private val quoteTextView = view.findViewById(R.id.quote) as TextView

    override fun onSetModel(model:String)
    {
        quoteTextView.text = model
        quoteTextView.setBackgroundColor(model.hashCode())
    }
}
