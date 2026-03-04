package com.example.coffeapp.Adaptor

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeapp.Domain.CategoryModel
import com.example.coffeapp.R
import com.example.coffeapp.databinding.ViewholderCategoryBinding

class CategoryAdaptor(val items:MutableList<CategoryModel>):
    RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {
        private lateinit var context: Context
        private var SelectePosition= -1
        private var LastSelectePosition= -1
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdaptor.ViewHolder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val items = items[position]
        holder.binding.tittlecategory.text = items.title

        holder.binding.root.setOnClickListener {
            LastSelectePosition=SelectePosition
            SelectePosition=position
            notifyItemChanged(LastSelectePosition)
            notifyItemChanged(SelectePosition)

            Handler(Looper.getMainLooper()).postDelayed({
                notifyItemChanged(LastSelectePosition)
                notifyItemChanged(SelectePosition)
            },500)
        }
        if(SelectePosition==position)
        {
            holder.binding.tittlecategory.setBackgroundResource(R.drawable.brown_full_corner)
            holder.binding.tittlecategory.setTextColor(context.resources.getColor(R.color.white))
        }
        else
        {
            holder.binding.tittlecategory.setBackgroundResource(R.drawable.white_full_corner)
            holder.binding.tittlecategory.setTextColor(context.resources.getColor(R.color.darkbrown))
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {}
}