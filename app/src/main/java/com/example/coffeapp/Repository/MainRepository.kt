package com.example.coffeapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeapp.Domain.BannerModel
import com.example.coffeapp.Domain.CategoryModel
import com.example.coffeapp.Domain.ItemsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener


class MainRepository {

    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {

        val listData = MutableLiveData<MutableList<BannerModel>>()

        val ref = firebaseDatabase.getReference("Banner")

        ref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                    android.util.Log.d("MainRepository", "loadBanner success: ${snapshot.value}")
                val list = mutableListOf<BannerModel>()

                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(BannerModel::class.java)
                    item?.let { list.add(it) }
                }

                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                    android.util.Log.e("MainRepository", "loadBanner error: ${error.message}")
                // You can log error here instead of TODO
            }
        })

        return listData   // ✅ CORRECT PLACE
    }

    fun loadCategoty(): LiveData<MutableList<CategoryModel>> {

        val listData = MutableLiveData<MutableList<CategoryModel>>()

        val ref = firebaseDatabase.getReference("Category")

        ref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                    android.util.Log.d("MainRepository", "loadCategory success: ${snapshot.value}")
                val list = mutableListOf<CategoryModel>()

                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(CategoryModel::class.java)
                    item?.let { list.add(it) }
                }

                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                    android.util.Log.e("MainRepository", "loadCategory error: ${error.message}")

                // You can log error here instead of TODO
            }
        })

        return listData   // ✅ CORRECT PLACE
    }

    fun loadPopualr(): LiveData<MutableList<ItemsModel>> {

        val listData = MutableLiveData<MutableList<ItemsModel>>()

        val ref = firebaseDatabase.getReference("Popular")

        ref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                    android.util.Log.d("MainRepository", "loadPopular success: ${snapshot.value}")

                val list = mutableListOf<ItemsModel>()

                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(ItemsModel::class.java)
                    item?.let { list.add(it) }
                }

                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {

                    android.util.Log.e("MainRepository", "loadPopular error: ${error.message}")

                // You can log error here instead of TODO
            }
        })

        return listData   // ✅ CORRECT PLACE
    }

    fun loadItemCategory(Categoryid: String?): LiveData<MutableList<ItemsModel>> {
        val ItemLiveData = MutableLiveData<MutableList<ItemsModel>>()
        val ref = firebaseDatabase.getReference("Items")
        val query: Query = ref.orderByChild("categoryId").equalTo(Categoryid)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                    android.util.Log.d("MainRepository", "loadItemCategory success: ${snapshot.value}")
                val list = mutableListOf<ItemsModel>()
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(ItemsModel::class.java)
                    item?.let { list.add(it) }
                }
                ItemLiveData.value = list
            }

            override fun onCancelled(error: DatabaseError) {

                    android.util.Log.e("MainRepository", "loadItemCategory error: ${error.message}")

            }

        })
        return ItemLiveData
    }
}