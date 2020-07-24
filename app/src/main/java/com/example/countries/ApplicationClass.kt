package com.example.countries

import com.example.countries.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ApplicationClass : DaggerApplication() {
	
	override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
		return DaggerAppComponent.builder().application(this).build()
	}
}