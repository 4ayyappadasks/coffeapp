package com.example.coffeapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeapp.Adaptor.itemListCategoryAdaptor
import com.example.coffeapp.R
import com.example.coffeapp.Viewmodel.MainViewModel
import com.example.coffeapp.databinding.ActivityItemListBinding

class ItemListActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemListBinding
    private  val viewModel= MainViewModel()
    private var id: String? = ""
    private var  title: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getbundle()
        initList()

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    private fun initList() {
        binding.apply {
            progressBar4.visibility = View.VISIBLE
            viewModel.loadItems(id).observe(this@ItemListActivity, Observer{
                listview.layoutManager = GridLayoutManager(this@ItemListActivity,2)
                listview.adapter = itemListCategoryAdaptor(it)
                progressBar4.visibility = View.GONE
            })
            backbutton.setOnClickListener {
                finish()
            }
        }
    }

    private fun getbundle() {
        id = intent.getStringExtra("id")
        title = intent.getStringExtra("title")

        binding.textView3.text = title ?: ""
    }
}