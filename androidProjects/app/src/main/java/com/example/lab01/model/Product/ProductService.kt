package com.example.lab01.model.Product

import android.accounts.Account
import com.example.lab01.model.Account.AccountDao
import com.github.javafaker.Faker
import kotlin.random.Random

class ProductService {
    private var products = mutableListOf<ProductDao>()

    init {
        val faker = Faker.instance()

        products = (1..20).map{
            ProductDao(
                id = it.toLong(),
                account = AccountDao(faker.elderScrolls().dragon(), faker.elderScrolls().city()),
                image_url = IMAGES[it % IMAGES.size],
                contextProduct = if (Random.nextInt(0, 100) > 50)
                    ContextProduct(faker.funnyName().name(), faker.animal().name(), faker.code().isbn10())
                else
                    null
            )
        }.toMutableList()
    }

    companion object {
        private val IMAGES = mutableListOf(
            "https://wp-s.ru/wallpapers/10/9/463314880930454/krasivyj-zakat-lesnoe-ozero-gory.jpg",
            "https://mobimg.b-cdn.net/v3/fetch/bd/bd4bb306b9dca36d5f8f0376e95d170c.jpeg?w=1470&r=0.5625",
            "https://vsegda-pomnim.com/uploads/posts/2022-04/1649126038_32-vsegda-pomnim-com-p-samie-krasivie-peizazhi-prirodi-foto-40.jpg",
            "https://thypix.com/wp-content/uploads/2018/05/Sommerlandschaft-Bilder-7.jpg",
            "https://pic.rutubelist.ru/video/6f/4b/6f4b6fb33b70a5cd33a257b581db12b4.jpg"
        )
    }

    public fun getProducts() = products
    public fun getProductById(id: Int?) = products.get(id!!)
}