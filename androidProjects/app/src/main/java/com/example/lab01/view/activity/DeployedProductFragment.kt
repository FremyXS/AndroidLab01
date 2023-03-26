package com.example.lab01.view.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lab01.R
import com.example.lab01.databinding.FragmentDeployedProductBinding
import com.example.lab01.viewmodel.CurrentIdLiveData

class DeployedProductFragment : Fragment() {
    lateinit var bind: FragmentDeployedProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind = FragmentDeployedProductBinding.inflate(layoutInflater, container, false)

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonId = arguments?.getString("product_id")
        val subhead = arguments?.getString("title")
        val title = arguments?.getString("subhead")
        val img_url = arguments?.getString("url_image")

        bind.topAppBar.title = title
        bind.productDesc.text = subhead
        bind.buttonProduct.text = StringBuilder().append(bind.buttonProduct.text).append(" ").append(buttonId).toString()
        Glide.with(bind.root).load(img_url) // Отрисовка фотографии пользователя с помощью библиотеки Glide
            .into(bind.productIamge)


        bind.topAppBar.setNavigationOnClickListener{
            findNavController().popBackStack()
        }
    }
}