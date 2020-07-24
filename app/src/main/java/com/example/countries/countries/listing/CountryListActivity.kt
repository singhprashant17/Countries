package com.example.countries.countries.listing

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.countries.BuildConfig
import com.example.countries.R
import com.example.countries.base.BaseActivity
import com.example.countries.countries.detail.CountryDetailActivity
import com.example.countries.databinding.ActivityCountryListBinding
import com.example.countries.databinding.DataBindingRecyclerviewAdapter
import com.example.countries.models.CountryModel
import javax.inject.Inject

class CountryListActivity : BaseActivity(),
	CountryListCallback,
	CountryItemClickListener {
	
	@Inject
	lateinit var factory: ViewModelProvider.Factory
	
	override val viewModel by lazy {
		ViewModelProvider(this, factory).get(CountryListViewModel::class.java)
	}
	
	override val contentViewBinding by lazy {
		ActivityCountryListBinding.inflate(layoutInflater)
	}
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		contentViewBinding.callback = this
		contentViewBinding.recyclerViewCounties.adapter = DataBindingRecyclerviewAdapter(
			bindingLayoutResId = R.layout.country_list_item,
			callback = this
		)
		viewModel.getCountriesInRegion(BuildConfig.REGION_CODE)
	}
	
	override fun onRefresh() {
		viewModel.getCountriesInRegion(BuildConfig.REGION_CODE)
	}
	
	override fun onCountryClicked(country: CountryModel?) {
		country?.let {
			startActivity(CountryDetailActivity.getIntent(this, country))
		}
	}
}