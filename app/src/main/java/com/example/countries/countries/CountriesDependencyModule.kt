package com.example.countries.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countries.countries.detail.CountryDetailViewModel
import com.example.countries.countries.listing.CountryListViewModel
import com.example.countries.data.DataSource
import dagger.Module
import dagger.Provides

@Module
object CountriesDependencyModule {
	
	@JvmStatic
	@Provides
	fun getViewModelFactory(dataSource: DataSource): ViewModelProvider.Factory {
		return object : ViewModelProvider.Factory {
			override fun <T : ViewModel?> create(modelClass: Class<T>): T {
				when (modelClass) {
					CountryListViewModel::class.java -> {
						return CountryListViewModel(
							dataSource = dataSource
						) as T
					}
					CountryDetailViewModel::class.java -> {
						return CountryDetailViewModel(
							appResources = dataSource.resources
						) as T
					}
					else -> {
						throw IllegalArgumentException("Unknown ViewModel class")
					}
				}
			}
		}
	}
}
