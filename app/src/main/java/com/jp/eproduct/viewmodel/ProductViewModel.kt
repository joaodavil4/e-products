package com.jp.eproduct.viewmodel

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jp.eproduct.model.Product

class ProductViewModel: ViewModel() {
    var isRefreshing = MutableLiveData(false)
    var lazyListState: LazyListState? = null

    val products = MutableLiveData<List<Product>>(listOf())
    val colors = arrayListOf("Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Black", "White", "Gray")

    fun loadItems(){
        getMockProducts()
    }

    fun refresh(){
        loadItems()
    }

    private fun getMockProducts(){
        isRefreshing.value = true
        val list = arrayListOf<Product>()

        repeat(10){
            val randomNum = (0..8).random()
            list.add(Product(Math.random().toString(), getMockColor(randomNum), randomNum.toString(), ""))
        }
        products.value = list
        isRefreshing.value = false

    }

    private fun getMockColor(color: Int): String {
        return colors[color]
    }
}