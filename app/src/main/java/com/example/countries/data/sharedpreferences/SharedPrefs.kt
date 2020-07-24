package com.example.countries.data.sharedpreferences

import androidx.lifecycle.LiveData

interface SharedPrefs {
	fun putString(key: String, value: String?)
	
	fun getString(key: String, defValue: String?): String?
	
	fun putInt(key: String, value: Int)
	
	fun getInt(key: String, defValue: Int): Int
	
	fun putBoolean(key: String, value: Boolean)
	
	fun getBoolean(key: String, defValue: Boolean): Boolean
	
	fun clear()
	
	fun putLong(key: String, value: Long)
	
	fun getLong(key: String, defValue: Long): Long
	
	fun remove(key: String)
	
	fun setObject(key: String, obj: Any)
	
	fun <T> getObject(key: String, inputClassType: Class<T>): T
	
	fun <T> getAsLiveData(key: String, outputClassType: Class<T>): LiveData<T>?
}