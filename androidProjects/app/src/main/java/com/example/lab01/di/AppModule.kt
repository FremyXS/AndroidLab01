package com.example.lab01.di

import android.app.Application
import com.example.lab01.model.Product.ProductService

class AppModule: Application() {
    val productService = ProductService()
}