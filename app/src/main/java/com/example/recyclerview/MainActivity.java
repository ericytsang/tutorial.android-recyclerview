package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_quotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomAdapter());
    }

    class CustomAdapter extends RecyclerView.Adapter<QuoteViewHolder>
    {
        private String[] quotes = getResources().getStringArray(R.array.quotes);

        @Override
        public QuoteViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
        {
            return QuoteViewHolder.make(parent);
        }

        @Override
        public void onBindViewHolder(QuoteViewHolder holder,int position)
        {
            holder.setModel(quotes[position]);
        }

        @Override
        public int getItemCount()
        {
            return quotes.length;
        }
    }
}
