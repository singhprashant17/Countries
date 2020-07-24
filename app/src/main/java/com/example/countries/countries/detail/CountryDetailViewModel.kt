package com.example.countries.countries.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.countries.base.BaseViewModel
import com.example.countries.data.resources.AppResources
import com.example.countries.models.CountryModel

class CountryDetailViewModel constructor(private val appResources: AppResources) : BaseViewModel() {
	private val _title = MutableLiveData("")
	val title: LiveData<String> = _title
	
	private val _borders = MutableLiveData("")
	val borders: LiveData<String> = _borders
	
	private val _languages = MutableLiveData("")
	val languages: LiveData<String> = _languages
	
	private val _location = MutableLiveData("")
	val location: LiveData<String> = _location
	
	fun displayDetails(countryModel: CountryModel?) {
		_title.value = countryModel?.name
		_borders.value = countryModel?.borders?.joinToString(separator = ", ")
		_languages.value = countryModel?.languages?.joinToString(separator = ", ")
		_location.value = countryModel?.latlng?.joinToString(separator = ", ") {
			it.toString()
		}
	}
}