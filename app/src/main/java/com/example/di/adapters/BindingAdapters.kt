package com.example.di.adapters

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.di.domain.model.Job

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Job>?) {
    Log.d("FROM-BIND-ADAPTER",data.toString())
    if (!data.isNullOrEmpty()){
        val adapter = recyclerView.adapter as JobAdapter
        adapter.submitList(data)
    }
}