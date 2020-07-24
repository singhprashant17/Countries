package com.example.countries.data.remote

import com.example.countries.data.remote.endpoints.CountriesApi
import retrofit2.Retrofit
import javax.inject.Inject

class ApiDataImpl @Inject constructor(
	private val retrofit: Retrofit
) : ApiData {
	
	override val countriesApi: CountriesApi by lazy {
		retrofit.create(CountriesApi::class.java)
	}
}