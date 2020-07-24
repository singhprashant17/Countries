package com.example.countries.data.session

import com.example.countries.data.sharedpreferences.SharedPrefs
import javax.inject.Inject

class AppSessionImpl @Inject constructor(
	private val sharedPrefs: SharedPrefs
) : AppSession {
	
	override
	fun getApiToken(): String {
		TODO()
	}
	
	override fun isUserLoggedIn(): Boolean {
		TODO()
	}
	
	override fun setUserLoggedIn() {
		TODO()
	}
	
	override fun setUserLoggedOut() {
		TODO()
	}
}