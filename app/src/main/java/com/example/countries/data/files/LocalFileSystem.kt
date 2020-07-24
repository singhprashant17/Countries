package com.example.countries.data.files

import java.io.File

interface LocalFileSystem {
	
	fun getDataDir(): File
	
	fun getFilesDir(): File
	
	fun getExternalFilesDir(type: String?): File?
	
	fun getCacheDir(): File
}