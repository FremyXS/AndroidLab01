package com.example.lab01.view.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab01.databinding.FragmentContainerBinding
import com.example.lab01.view.adapter.ProductsAdapter
import com.example.lab01.viewmodel.CurrentIdLiveData

class ContainerFragment : Fragment() {
    private lateinit var bind : FragmentContainerBinding
    private lateinit var adapter: ProductsAdapter
    private var liveData: CurrentIdLiveData = CurrentIdLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        liveData.getValue()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentContainerBinding.inflate(layoutInflater, container, false)

        val manager = LinearLayoutManager(this.context)

        adapter = ProductsAdapter()
        adapter.productsList = liveData.getValue().value!!.getProducts()

        bind.container.layoutManager = manager
        bind.container.adapter = adapter

        // Inflate the layout for this fragment
        return bind.root
    }
}