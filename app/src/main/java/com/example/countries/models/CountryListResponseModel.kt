package com.example.countries.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class CountryListResponseModel : ArrayList<CountryModel>()

@Parcelize
data class CountryModel(
	@SerializedName("alpha2Code")
	val alpha2Code: String?, // YE
	@SerializedName("alpha3Code")
	val alpha3Code: String?, // YEM
	@SerializedName("altSpellings")
	val altSpellings: List<String>?,
	@SerializedName("area")
	val area: Double?, // 527968.0
	@SerializedName("borders")
	val borders: List<String>?,
	@SerializedName("callingCodes")
	val callingCodes: List<String>?,
	@SerializedName("capital")
	val capital: String?, // Sana'a
	@SerializedName("currencies")
	val currencies: List<String>?,
	@SerializedName("demonym")
	val demonym: String?, // Yemeni
	@SerializedName("gini")
	val gini: Double?, // 37.7
	@SerializedName("languages")
	val languages: List<String>?,
	@SerializedName("latlng")
	val latlng: List<Double>?,
	@SerializedName("name")
	val name: String?, // Yemen
	@SerializedName("nativeName")
	val nativeName: String?, // اليَمَن
	@SerializedName("numericCode")
	val numericCode: String?, // 887
	@SerializedName("population")
	val population: Int?, // 25956000
	@SerializedName("region")
	val region: String?, // Asia
	@SerializedName("relevance")
	val relevance: String?, // 0
	@SerializedName("subregion")
	val subregion: String?, // Western Asia
	@SerializedName("timezones")
	val timezones: List<String>?,
	@SerializedName("topLevelDomain")
	val topLevelDomain: List<String>?,
	@SerializedName("translations")
	val translations: Translations?
) : Parcelable

@Parcelize
data class Translations(
	@SerializedName("de")
	val de: String?, // Jemen
	@SerializedName("es")
	val es: String?, // Yemen
	@SerializedName("fr")
	val fr: String?, // Yémen
	@SerializedName("it")
	val `it`: String?, // Yemen
	@SerializedName("ja")
	val ja: String? // イエメン
) : Parcelable