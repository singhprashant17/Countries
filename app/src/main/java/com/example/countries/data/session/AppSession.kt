package com.example.countries.data.session

interface AppSession {
	
	fun getApiToken(): String
	
	fun isUserLoggedIn(): Boolean
	
	fun setUserLoggedIn()
	
	fun setUserLoggedOut()
	
}