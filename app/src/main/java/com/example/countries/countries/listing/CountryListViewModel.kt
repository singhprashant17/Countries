package com.example.countries.countries.listing

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.countries.base.BaseViewModel
import com.example.countries.countries.detail.CountryDetailViewModel
import com.example.countries.data.DataSource
import com.example.countries.models.CountryModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CountryListViewModel(
	private val dataSource: DataSource
) : BaseViewModel() {
	
	private val _isLoading = MutableLiveData(true)
	val isLoading: LiveData<Boolean> = _isLoading
	
	val countriesList = MutableLiveData<List<CountryItemViewModel>>()
	
	@SuppressLint("CheckResult")
	fun getCountriesInRegion(regionCode: String) {
		dataSource.apiData.countriesApi.getCountiesInRegion(regionCode)
			.doOnSubscribe {
				compositeDisposable.add(it)
				_isLoading.postValue(true)
			}
			.doOnSuccess {
				countriesList.postValue(it.mapTo(ArrayList()) {
					CountryItemViewModel(
						it
					)
				})
			}
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe({
				_isLoading.value = false
			}, {
				_isLoading.value = false
				Log.e(CountryDetailViewModel::class.simpleName, "getCountriesInRegion: ", it)
			})
	}
}

interface CountryListCallback {
	fun onRefresh()
}

class CountryItemViewModel constructor(val country: CountryModel?) {
	val name = country?.name
	val capital = country?.capital
	val population = country?.population?.toString()
	val currency = country?.currencies?.joinToString(separator = ", ")
}

interface CountryItemClickListener {
	fun onCountryClicked(country: CountryModel?)
}