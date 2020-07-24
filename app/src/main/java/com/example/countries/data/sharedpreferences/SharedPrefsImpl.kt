package com.example.countries.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Named

class SharedPrefsImpl @Inject constructor(
	context: Context,
	@Named("PREFERENCE_FILE_NAME") fileName: String,
	private val gson: Gson
) : SharedPrefs {
	
	private val cacheMap = HashMap<String, MutableLiveData<*>>()
	
	private val sharedPrefs: SharedPreferences by lazy {
		context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
	}
	
	@Synchronized
	override fun clear() {
		sharedPrefs.edit().clear().apply()
		for (entry in cacheMap) {
			entry.value.value = null
		}
		cacheMap.clear()
	}
	
	@Synchronized
	override fun putString(key: String, value: String?) {
		sharedPrefs.edit().putString(key, value).apply()
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(value)
		} else {
			cacheMap[key]!!.value = value
		}
	}
	
	@Synchronized
	override fun getString(key: String, defValue: String?): String? {
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(sharedPrefs.getString(key, defValue))
		}
		return cacheMap[key]!!.value as String?
	}
	
	@Synchronized
	override fun putInt(key: String, value: Int) {
		sharedPrefs.edit().putInt(key, value).apply()
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(value)
		} else {
			cacheMap[key]!!.value = value
		}
	}
	
	@Synchronized
	override fun getInt(key: String, defValue: Int): Int {
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(sharedPrefs.getInt(key, defValue))
		}
		return cacheMap[key]!!.value as Int
	}
	
	@Synchronized
	override fun putBoolean(key: String, value: Boolean) {
		sharedPrefs.edit().putBoolean(key, value).apply()
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(value)
		} else {
			cacheMap[key]!!.value = value
		}
	}
	
	@Synchronized
	override fun getBoolean(key: String, defValue: Boolean): Boolean {
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(sharedPrefs.getBoolean(key, defValue))
		}
		return cacheMap[key]!!.value as Boolean
	}
	
	@Synchronized
	override fun putLong(key: String, value: Long) {
		sharedPrefs.edit().putLong(key, value).apply()
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(value)
		} else {
			cacheMap[key]!!.value = value
		}
	}
	
	@Synchronized
	override fun getLong(key: String, defValue: Long): Long {
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(sharedPrefs.getLong(key, defValue))
		}
		return cacheMap[key]!!.value as Long
	}
	
	@Synchronized
	override fun remove(key: String) {
		sharedPrefs.edit().remove(key).apply()
		if (cacheMap[key] != null) {
			cacheMap[key]!!.value = null
		}
		cacheMap.remove(key)
	}
	
	@Synchronized
	override fun setObject(key: String, obj: Any) {
		val stringVal = gson.toJson(obj)
		sharedPrefs.edit().putString(key, stringVal).apply()
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(stringVal)
		} else {
			cacheMap[key]!!.value = stringVal
		}
	}
	
	@Synchronized
	override fun <T> getObject(key: String, inputClassType: Class<T>): T {
		val stringVal = sharedPrefs.getString(key, null)
		if (cacheMap[key] == null) {
			cacheMap[key] = MutableLiveData(gson.fromJson<T>(stringVal, inputClassType))
		}
		return cacheMap[key]!!.value as T
	}
	
	@Synchronized
	override fun <T> getAsLiveData(key: String, outputClassType: Class<T>): LiveData<T>? {
		return cacheMap[key] as LiveData<T>
	}
}