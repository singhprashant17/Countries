package com.example.countries.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object DataBindingAdapter {
	@JvmStatic
	@BindingAdapter("list")
	fun setRecyclerView(
		recyclerView: RecyclerView,
		list: List<*>?
	) {
		if (recyclerView.adapter is DataBindingRecyclerviewAdapter) {
			(recyclerView.adapter as DataBindingRecyclerviewAdapter).apply {
				this.list.clear()
				this.list.addAll(list.orEmpty() as Collection<Any>)
				notifyDataSetChanged()
			}
		}
	}
}