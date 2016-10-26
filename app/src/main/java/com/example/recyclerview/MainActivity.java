package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private CustomAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewAdapter = new CustomAdapter();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_quotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
        case R.id.action_add:
            recyclerViewAdapter.addRandom();
            return true;
        case R.id.action_remove:
            recyclerViewAdapter.removeRandom();
            return true;
        case R.id.action_shuffle:
            recyclerViewAdapter.shuffleExisting();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    private class CustomAdapter extends RecyclerView.Adapter<QuoteViewHolder>
    {
        private String[] quotePool = getResources().getStringArray(R.array.quotes);

        private List<String> quotes = new ArrayList<>();

        public CustomAdapter()
        {
            super();
            setHasStableIds(true);
        }

        @Override
        public long getItemId(int position)
        {
            return quotes.get(position).hashCode();
        }

        @Override
        public QuoteViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
        {
            return QuoteViewHolder.make(parent);
        }

        @Override
        public void onBindViewHolder(QuoteViewHolder holder,int position)
        {
            holder.setModel(quotes.get(position));
        }

        @Override
        public int getItemCount()
        {
            return quotes.size();
        }

        public void addRandom()
        {
            int listIndex = (int) Math.floor((1-Math.random())*quotes.size());
            int quotePoolIndex = (int) Math.floor((1-Math.random())*quotePool.length);
            quotes.add(listIndex,quotePool[quotePoolIndex]);
            notifyDataSetChanged();
        }

        public void shuffleExisting()
        {
            Collections.shuffle(quotes);
            notifyDataSetChanged();
        }

        public void removeRandom()
        {
            if (!quotes.isEmpty())
            {
                int listIndex = (int) Math.floor((1-Math.random())*quotes.size());
                quotes.remove(listIndex);
                notifyDataSetChanged();
            }
        }
    }
}
