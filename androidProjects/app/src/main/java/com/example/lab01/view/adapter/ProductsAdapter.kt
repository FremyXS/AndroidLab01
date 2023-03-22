package com.example.lab01.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab01.R
import com.example.lab01.databinding.FragmentProduct2Binding
import com.example.lab01.databinding.FragmentProductBinding
import com.example.lab01.model.Product.ProductDao
import com.example.lab01.view.activity.ProductFragment

class ProductsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var productsList: List<ProductDao> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    fun getId(head: String, subHead: String){
        productsList.get(1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        when(viewType){
            0 -> return ItemHolder(FragmentProductBinding.inflate(inflater, parent, false))
            2 -> return ItemHolderLow(FragmentProduct2Binding.inflate(inflater, parent, false))
            else -> throw Exception("Error Type View")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.getItemViewType()){
            0 -> {
                val holderMain = holder as ItemHolder
                val product:ProductDao = productsList[position]
                val context = holder.itemView.context

                with(holderMain.bind){
                    headerPost.text = product.account.header
                    headerPost.id = position
                    subheadPost.text = product.account.subhead

                    if(product.contextProduct != null){
                        productCotextTitle.text = product.contextProduct.title
                        productCotextSubtitle.text = product.contextProduct.sub_title
                        productCotextDescription.text = product.contextProduct.decription
                    }

                    Glide.with(context).load(product.image_url) // Отрисовка фотографии пользователя с помощью библиотеки Glide
                        .into(productImage)
                }
            }

            2 -> {
                val holderMain = holder as ItemHolderLow
                val product:ProductDao = productsList[position]
                val context = holder.itemView.context

                with(holderMain.bind){
                    headerPost.text = product.account.header
                    headerPost.id = position
                    subheadPost.text = product.account.subhead

                    Glide.with(context).load(product.image_url) // Отрисовка фотографии пользователя с помощью библиотеки Glide
                        .into(productImage)
                }

            }
        }
    }

    override fun getItemCount(): Int = productsList.size

    fun submitList(items:List<ProductDao>){
        productsList = items
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if(productsList[position].contextProduct == null)
            2
        else 0
    }
    class ItemHolder(val bind: FragmentProductBinding):RecyclerView.ViewHolder(bind.root){
    }
    class ItemHolderLow(val bind: FragmentProduct2Binding):RecyclerView.ViewHolder(bind.root){
    }
}