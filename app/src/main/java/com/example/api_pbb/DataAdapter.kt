package com.example.api_pbb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_pbb.databinding.ItemDataBinding
import com.example.api_pbb.model.DataItem

class DataAdapter(val data: List<DataItem>?, private val click: onClickItem) :
    RecyclerView.Adapter<DataAdapter.MyHolder>() {
        private lateinit var binding: ItemDataBinding
        inner class MyHolder(binding: ItemDataBinding) :
                RecyclerView.ViewHolder(binding.root) {
                    fun onBind(get: DataItem?) {
                        binding.tvName.text = get?.staffName
                        binding.tvPhone.text = get?.staffHp
                        binding.tvAddress.text = get?.staffAlamat
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  MyHolder(binding)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        binding.tvName.setOnClickListener() {
            click.clicked(data?.get(position))
        }
    }

    interface onClickItem{
        fun clicked (item: DataItem?)
        fun delete(item: DataItem?)
    }
}