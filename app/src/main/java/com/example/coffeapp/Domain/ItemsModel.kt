package com.example.coffeapp.Domain

import java.io.Serializable

data class ItemsModel(
    val title: String = "",
    val description: String = "",
    val picUrl: ArrayList<String> = ArrayList(),
    val price: Double = 0.0,
    val rate: Double = 0.0,
    val numberincart: Int = 0,
    val extra: String = ""
) : Serializable