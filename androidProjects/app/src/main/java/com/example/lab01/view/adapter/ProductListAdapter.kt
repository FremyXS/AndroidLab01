package com.example.lab01.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab01.databinding.FragmentProduct2Binding
import com.example.lab01.databinding.FragmentProductBinding
import com.example.lab01.model.Product.ProductDao

class ProductListAdapter(private val listener: Listener) : ListAdapter<ProductDao, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val binding = FragmentProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ItemHolder(binding)
            }
            else -> {
                val binding = FragmentProduct2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ItemHolderLow(binding)
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).contextProduct == null)
            1
        else 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as ItemHolder).bind(getItem(position), listener, holder.itemView.context)
            else -> (holder as ItemHolderLow).bind(getItem(position), listener, holder.itemView.context)

        }
    }

    class ItemHolder(val bind: FragmentProductBinding):RecyclerView.ViewHolder(bind.root){

        fun bind(product: ProductDao, listener: Listener, context: Context) = with(bind) {
            imageButton.setOnClickListener {
                listener.onClick(product)
            }
            headerPost.text = product.account.header
            subheadPost.text = product.account.subhead

            productCotextTitle.text = product.contextProduct!!.title
            productCotextSubtitle.text = product.contextProduct.sub_title
            productCotextDescription.text = product.contextProduct.decription

            Glide.with(context).load(product.image_url) // Отрисовка фотографии пользователя с помощью библиотеки Glide
                .into(productImage)
        }
    }
    class ItemHolderLow(val bind: FragmentProduct2Binding):RecyclerView.ViewHolder(bind.root){
        fun bind(product: ProductDao, listener: Listener, context: Context) = with(bind) {
            productImage.setOnClickListener {
                listener.onClick(product)
            }
            headerPost.text = product.account.header
            subheadPost.text = product.account.subhead

            Glide.with(context).load(product.image_url) // Отрисовка фотографии пользователя с помощью библиотеки Glide
                .into(productImage)
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<ProductDao>() {

        override fun areItemsTheSame(oldItem: ProductDao, newItem: ProductDao): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ProductDao, newItem: ProductDao): Boolean {
            return oldItem == newItem
        }
    }

    interface Listener {
        fun onClick(product: ProductDao)
    }

}