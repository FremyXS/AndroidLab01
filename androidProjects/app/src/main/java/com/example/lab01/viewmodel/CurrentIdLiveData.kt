package com.example.lab01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab01.model.Product.ProductDao
import com.example.lab01.model.Product.ProductService

class CurrentIdLiveData: ViewModel() {
    private var value: MutableLiveData<ProductService> =MutableLiveData<ProductService>(ProductService());

    public fun getValue(): MutableLiveData<ProductService> {

        return value;
    }

    fun getById(id: Int): ProductDao {
        return value.value!!.getProductById(id)
    }
}