package com.example.lab01.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab01.R
import com.example.lab01.databinding.FragmentContainerBinding
import com.example.lab01.model.Product.ProductDao
import com.example.lab01.view.adapter.ProductListAdapter
import com.example.lab01.viewmodel.CurrentIdLiveData

class ContainerFragment : Fragment(),  ProductListAdapter.Listener {

    private var _binding: FragmentContainerBinding? = null
    private val newsAdapter = ProductListAdapter(this)
    private var liveData: CurrentIdLiveData = CurrentIdLiveData()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        liveData.setValue()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun init(){
        val products = liveData.getValue().value!!.getProducts()
        newsAdapter.submitList(products)
        binding.container.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        binding.container.adapter = newsAdapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(product: ProductDao) {
        val bundle = Bundle()
        bundle.putString("product_id", product.id.toString())
        bundle.putString("title",product.account.header)
        bundle.putString("subhead",product.account.subhead)
        bundle.putString("url_image",product.image_url)
        findNavController().navigate(R.id.action_containerFragment_to_deployedProductFragment, bundle)
    }
}