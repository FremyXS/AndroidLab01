package com.example.lab01.model.Product

import com.example.lab01.model.Account.AccountDao
import kotlin.properties.Delegates

data class ContextProduct(val title: String, val sub_title: String, val decription: String)

data class ProductDao(
    val id: Long,
    val account: AccountDao,
    val image_url: String,
    val contextProduct: ContextProduct?
)