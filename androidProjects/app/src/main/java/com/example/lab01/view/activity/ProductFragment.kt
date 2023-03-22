package com.example.lab01.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.FOCUS_RIGHT
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.lab01.R
import com.example.lab01.databinding.FragmentProductBinding
import com.example.lab01.view.adapter.ProductsAdapter
import com.example.lab01.viewmodel.CurrentIdLiveData

class ProductFragment : Fragment(), OnClickListener {
    lateinit var bind: FragmentProductBinding
    lateinit var navController: NavController
    private val currentIdLiveData: CurrentIdLiveData = CurrentIdLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentProductBinding.inflate(layoutInflater, container, false)

        navController = NavHostFragment.findNavController(this)

        bind.imageButton.setOnClickListener{
            findNavController().navigate(R.id.action_containerFragment_to_deployedProductFragment, null)
        }
        // Inflate the layout for this fragment
        return bind.root
    }


    override fun onClick(p0: View?) {
//        var prAdap = ProductsAdapter()
//        prAdap.productsList = CurrentProductServiceLiveData().getAll()


        navController.navigate(R.id.action_containerFragment_to_deployedProductFragment, null)
    }

}