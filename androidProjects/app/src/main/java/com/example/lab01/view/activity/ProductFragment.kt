package com.example.lab01.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab01.databinding.FragmentProductBinding

class ProductFragment : Fragment(){
    lateinit var bind: FragmentProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentProductBinding.inflate(layoutInflater, container, false)


        // Inflate the layout for this fragment
        return bind.root
    }

}