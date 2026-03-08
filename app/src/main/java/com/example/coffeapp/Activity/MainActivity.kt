package com.example.coffeapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.coffeapp.Adaptor.CategoryAdaptor
import com.example.coffeapp.Adaptor.PopularAdaptor
import com.example.coffeapp.Viewmodel.MainViewModel
import com.example.coffeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initbanner()
        initcategory()
        initpopular()
    }

    private fun initpopular() {
        binding.progressBar3.visibility = View.VISIBLE
        viewModel.loadPopualr().observeForever {
            binding.popularcofferecyclerView.layoutManager =
                GridLayoutManager(this, 2)
            binding.popularcofferecyclerView.adapter = PopularAdaptor(it)
            binding.progressBar3.visibility = View.GONE
        }
        viewModel.loadPopualr()
    }

    private fun initcategory() {
        binding.progressBar2.visibility = View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.categoryrecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.categoryrecyclerView.adapter =  CategoryAdaptor(it)
            binding.progressBar2.visibility = View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initbanner() {
        binding.progressBar.visibility = View.VISIBLE

        viewModel.loadBanner().observe(this) { list ->

            if (!list.isNullOrEmpty()) {
                Glide.with(this)
                    .load(list[0].url)
                    .into(binding.banner)
            }

            binding.progressBar.visibility = View.GONE
        }
        viewModel.loadBanner()
    }
}
