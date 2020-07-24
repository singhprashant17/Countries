package com.example.countries.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.BR

open class DataBindingRecyclerviewAdapter constructor(
	private var bindingLayoutResId: Int,
	private var callback: Any? = null
) : RecyclerView.Adapter<DataBindingViewHolder>() {
	
	val list = mutableListOf<Any>()
	
	override fun getItemCount(): Int {
		return list.size
	}
	
	open fun getItem(position: Int): Any? {
		return list.get(position)
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
		val binding = DataBindingUtil.inflate<ViewDataBinding>(
			LayoutInflater.from(parent.context),
			bindingLayoutResId,
			parent,
			false
		)
		binding?.setVariable(BR.callback, callback)
		return DataBindingViewHolder(binding)
	}
	
	override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
		holder.bind(getItem(position))
	}
}

open class DataBindingViewHolder(var binding: ViewDataBinding) :
	RecyclerView.ViewHolder(binding.root) {
	
	fun bind(data: Any?) {
		binding.setVariable(BR.viewModel, data)
	}
}