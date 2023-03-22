package com.example.lab01.view.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lab01.R
import com.example.lab01.databinding.FragmentDeployedProductBinding
import com.example.lab01.databinding.FragmentProductBinding
import com.example.lab01.model.Product.ProductService
import com.example.lab01.viewmodel.CurrentIdLiveData

class DeployedProductFragment : Fragment() {
    lateinit var bind: FragmentDeployedProductBinding
    private val currentIdLiveData: CurrentIdLiveData = CurrentIdLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val product = currentIdLiveData.getById(1)
        bind = FragmentDeployedProductBinding.inflate(layoutInflater, container, false)

        bind.productDesc.text = if(product.contextProduct != null) product.contextProduct.decription else "пусто"
        Glide.with(bind.root).load(product.image_url) // Отрисовка фотографии пользователя с помощью библиотеки Glide
            .into(bind.productIamge)

        return bind.root
    }
}