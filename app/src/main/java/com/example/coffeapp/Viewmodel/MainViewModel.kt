package com.example.coffeapp.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffeapp.Domain.BannerModel
import com.example.coffeapp.Domain.CategoryModel
import com.example.coffeapp.Domain.ItemsModel
import com.example.coffeapp.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()

    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategoty()
    }
    fun loadPopualr(): LiveData<MutableList<ItemsModel>>{
        return repository.loadPopualr()
    }
}