package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class ViewHolder<Model> extends RecyclerView.ViewHolder
{
    private final View view;

    private Model model;

    protected ViewHolder(View itemView)
    {
        super(itemView);
        view = itemView;
    }

    public final View getView()
    {
        return view;
    }

    public final Model getModel()
    {
        return model;
    }

    public final void setModel(Model model)
    {
        this.model = model;
        onSetModel(model);
    }

    protected abstract void onSetModel(Model newModel);

    protected final Context getContext()
    {
        return view.getContext();
    }
}
