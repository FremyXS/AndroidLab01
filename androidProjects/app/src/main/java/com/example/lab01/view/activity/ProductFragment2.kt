package com.example.lab01.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab01.databinding.FragmentProduct2Binding

class ProductFragment2 : Fragment(){
    lateinit var bind: FragmentProduct2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentProduct2Binding.inflate(layoutInflater, container, false)

        return bind.root
    }
}