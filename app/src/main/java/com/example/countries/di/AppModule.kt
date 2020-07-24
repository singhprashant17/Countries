package com.example.countries.di

import android.content.Context
import com.example.countries.ApplicationClass
import com.example.countries.BuildConfig
import com.example.countries.data.DataSource
import com.example.countries.data.DataSourceImpl
import com.example.countries.data.files.LocalFileSystem
import com.example.countries.data.files.LocalFileSystemImpl
import com.example.countries.data.remote.ApiData
import com.example.countries.data.remote.ApiDataImpl
import com.example.countries.data.resources.AppResources
import com.example.countries.data.resources.AppResourcesImpl
import com.example.countries.data.session.AppSession
import com.example.countries.data.session.AppSessionImpl
import com.example.countries.data.sharedpreferences.SharedPrefs
import com.example.countries.data.sharedpreferences.SharedPrefsImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
object AppModule {
	@Named("BASE_URL")
	@Provides
	@Singleton
	@JvmStatic
	fun getBaseUrl(): String {
		return BuildConfig.BASE_URL
	}
	
	@Named("PREFERENCE_FILE_NAME")
	@JvmStatic
	@Provides
	@Singleton
	fun getAppPreferenceName(): String {
		return "${BuildConfig.APPLICATION_ID}_preference"
	}
	
	@Provides
	@Singleton
	@JvmStatic
	fun getGson(): Gson {
		return GsonBuilder().create()
	}
	
	@Provides
	@Singleton
	@JvmStatic
	fun getRetrofit(
		@Named("BASE_URL") baseUrl: String,
		client: OkHttpClient
	): Retrofit {
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.client(client)
			.build()
	}
	
	@Provides
	@Singleton
	@JvmStatic
	fun getOkHttpInterceptors(): Array<Interceptor> {
		return arrayOf(
			HttpLoggingInterceptor().apply {
				level = if (BuildConfig.DEBUG)
					HttpLoggingInterceptor.Level.BODY
				else
					HttpLoggingInterceptor.Level.NONE
			}
		)
	}
	
	@Provides
	@Singleton
	@JvmStatic
	fun getOkHttpClient(vararg interceptors: Interceptor): OkHttpClient {
		val httpClient = OkHttpClient.Builder().apply {
			connectTimeout(10, TimeUnit.SECONDS)
			readTimeout(30, TimeUnit.SECONDS)
			addInterceptor { chain ->
				val original = chain.request()
				val request = original.newBuilder()
					.header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "475eebcce4msh1e04982ca510f1bp148de4jsn7d672619f9c0")
					.header("useQueryString", "true")
					.method(original.method(), original.body())
					.build()
				chain.proceed(request)
			}
			
			interceptors.forEach {
				addInterceptor(it)
			}
		}
		return httpClient.build()
	}
	
	@Provides
	@Singleton
	@JvmStatic
	fun getSharedPreferences(sharedPrefsImpl: SharedPrefsImpl): SharedPrefs = sharedPrefsImpl
	
	@Provides
	@Singleton
	@JvmStatic
	fun getContext(application: ApplicationClass): Context = application
	
	@Provides
	@Singleton
	@JvmStatic
	fun getDataSource(dataSource: DataSourceImpl): DataSource = dataSource
	
	@Provides
	@Singleton
	@JvmStatic
	fun getApiData(apiData: ApiDataImpl): ApiData = apiData
	
	@Provides
	@Singleton
	@JvmStatic
	fun getLocalFileSystem(localFileSystem: LocalFileSystemImpl): LocalFileSystem = localFileSystem
	
	@Provides
	@Singleton
	@JvmStatic
	fun getAppResources(appResources: AppResourcesImpl): AppResources = appResources
	
	@Provides
	@Singleton
	@JvmStatic
	fun getAppSession(appSession: AppSessionImpl): AppSession = appSession
}