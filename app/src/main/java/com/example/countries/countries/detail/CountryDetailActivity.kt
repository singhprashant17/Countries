package com.example.countries.countries.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.countries.base.BaseActivity
import com.example.countries.countries.detail.CountryDetailActivity.Keys.ARG_COUNTRY
import com.example.countries.databinding.ActivityCountryDetailBinding
import com.example.countries.models.CountryModel
import javax.inject.Inject

class CountryDetailActivity : BaseActivity() {
	
	companion object {
		@JvmStatic
		fun getIntent(context: Context, countryModel: CountryModel): Intent {
			return Intent(context, CountryDetailActivity::class.java).apply {
				putExtra(ARG_COUNTRY, countryModel)
			}
		}
	}
	
	object Keys {
		const val ARG_COUNTRY = "country"
	}
	
	@Inject
	lateinit var factory: ViewModelProvider.Factory
	
	override val viewModel by lazy {
		ViewModelProvider(this, factory).get(CountryDetailViewModel::class.java)
	}
	
	override val contentViewBinding by lazy {
		ActivityCountryDetailBinding.inflate(layoutInflater)
	}
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewModel.displayDetails(intent.getParcelableExtra(ARG_COUNTRY))
	}
}