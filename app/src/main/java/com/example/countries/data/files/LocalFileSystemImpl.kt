package com.example.countries.data.files

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import javax.inject.Inject

class LocalFileSystemImpl @Inject constructor(
	private val context: Context
) : LocalFileSystem {
	
	@RequiresApi(Build.VERSION_CODES.N)
	override fun getDataDir(): File {
		return context.dataDir
	}
	
	override fun getFilesDir(): File {
		return context.filesDir
	}
	
	override fun getExternalFilesDir(type: String?): File? {
		return context.externalCacheDir
	}
	
	override fun getCacheDir(): File {
		return context.cacheDir
	}
}