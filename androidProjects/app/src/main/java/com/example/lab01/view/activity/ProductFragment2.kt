package com.example.lab01.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lab01.R
import com.example.lab01.databinding.FragmentProduct2Binding
import com.example.lab01.viewmodel.CurrentIdLiveData

class ProductFragment2 : Fragment(), View.OnClickListener {
    lateinit var bind: FragmentProduct2Binding
    lateinit var navController: NavController
    private val currentIdLiveData: CurrentIdLiveData = CurrentIdLiveData()
    public var idIt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentProduct2Binding.inflate(layoutInflater, container, false)
        navController = NavHostFragment.findNavController(this)
        bind.productImage.setOnClickListener(this)

        return bind.root
    }


    override fun onClick(p0: View?) {
        navController.navigate(R.id.action_containerFragment_to_deployedProductFragment, null)
    }
}