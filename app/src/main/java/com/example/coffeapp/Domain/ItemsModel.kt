package com.example.coffeapp.Domain

import java.io.Serializable

data class ItemsModel(
    var title: String = "",
    var description: String = "",
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rateing: Double = 0.0,
    var numberIncart: Int = 0,
    var extra: String = ""
) : Serializable