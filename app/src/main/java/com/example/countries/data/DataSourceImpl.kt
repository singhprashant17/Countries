package com.example.countries.data

import com.example.countries.data.files.LocalFileSystem
import com.example.countries.data.remote.ApiData
import com.example.countries.data.resources.AppResources
import com.example.countries.data.session.AppSession
import com.example.countries.data.sharedpreferences.SharedPrefs
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
	override val sharedPrefs: SharedPrefs,
	override val apiData: ApiData,
	override val localFileSystem: LocalFileSystem,
	override val resources: AppResources,
	override val appSession: AppSession
) : DataSource