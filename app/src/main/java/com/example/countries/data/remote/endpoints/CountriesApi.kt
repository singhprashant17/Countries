package com.example.countries.data.remote.endpoints

import com.example.countries.models.CountryListResponseModel
import com.google.gson.JsonElement
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountriesApi {
	
	@GET("/region/{regionCode}")
	fun getCountiesInRegion(@Path("regionCode") regionCode: String): Single<CountryListResponseModel>
	
	@GET("/alpha")
	fun getCountryByCountryCode(@Query("codes") countryCode: String): Single<JsonElement>
}