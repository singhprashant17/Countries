package com.example.countries.di

import com.example.countries.ApplicationClass
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		AndroidSupportInjectionModule::class,
		ActivityBuildersModule::class,
		AppModule::class
	]
)
interface AppComponent : AndroidInjector<ApplicationClass> {
	
	@Component.Builder
	interface Builder {
		
		@BindsInstance
		fun application(application: ApplicationClass): Builder
		
		fun build(): AppComponent
	}
}
