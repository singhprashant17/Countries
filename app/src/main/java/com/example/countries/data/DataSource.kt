package com.example.countries.data

import com.example.countries.data.files.LocalFileSystem
import com.example.countries.data.remote.ApiData
import com.example.countries.data.resources.AppResources
import com.example.countries.data.session.AppSession
import com.example.countries.data.sharedpreferences.SharedPrefs

interface DataSource {
	val sharedPrefs: SharedPrefs
	
	val apiData: ApiData
	
	val localFileSystem: LocalFileSystem
	
	val resources: AppResources
	
	val appSession: AppSession
}