package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuoteViewHolder extends ViewHolder<String>
{
    private final TextView quoteTextView = (TextView) getView().findViewById(R.id.quote);

    private QuoteViewHolder(View itemView)
    {
        super(itemView);
    }

    public static QuoteViewHolder make(ViewGroup parent)
    {
        LayoutInflater viewInflater = LayoutInflater.from(parent.getContext());
        View quoteListItemView = viewInflater.inflate(R.layout.listitem_quote,parent,false);
        return new QuoteViewHolder(quoteListItemView);
    }

    @Override
    protected void onSetModel(String newModel)
    {
        quoteTextView.setText(newModel);
        quoteTextView.setBackgroundColor(newModel.hashCode());
    }
}
