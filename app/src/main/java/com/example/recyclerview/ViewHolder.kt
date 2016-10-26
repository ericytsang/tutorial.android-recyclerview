package com.example.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class ViewHolder<Model> protected constructor(val view:View):RecyclerView.ViewHolder(view)
{
    var model:Model? = null

        set(value)
        {
            field = value
            onSetModel(value!!)
        }

    protected abstract fun onSetModel(model:Model)

    protected val context:Context get() = view.context
}
