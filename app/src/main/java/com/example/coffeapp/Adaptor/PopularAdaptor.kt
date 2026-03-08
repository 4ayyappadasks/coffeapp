package com.example.coffeapp.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeapp.Domain.ItemsModel
import com.example.coffeapp.databinding.ViewholderPopularBinding

class PopularAdaptor(val items:MutableList<ItemsModel>):
    RecyclerView.Adapter<PopularAdaptor.ViewHolder>(){

        lateinit var context: Context

    class ViewHolder(val binding: ViewholderPopularBinding):
    RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdaptor.ViewHolder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdaptor.ViewHolder, position: Int) {
        holder.binding.titletext.text = items[position].title
        holder.binding.pricetext.text = items[position].price.toString()
        holder.binding.subtitletext.text = items[position].extra

        Glide.with(context)
            .load(items[position].picUrl [0])
            .into(holder.binding.pic)
    }

    override fun getItemCount(): Int = items.size
}