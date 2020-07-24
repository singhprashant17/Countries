package com.example.countries.di

import com.example.countries.countries.CountriesDependencyModule
import com.example.countries.countries.detail.CountryDetailActivity
import com.example.countries.countries.listing.CountryListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
	@ContributesAndroidInjector(modules = [CountriesDependencyModule::class])
	abstract fun bindCountryListActivity(): CountryListActivity
	
	@ContributesAndroidInjector(modules = [CountriesDependencyModule::class])
	abstract fun bindCountryDetailActivity(): CountryDetailActivity
}
