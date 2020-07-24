package com.example.countries.data.resources

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.*

interface AppResources {
	val context: Context
	
	fun getText(@StringRes textResourceId: Int): CharSequence
	
	fun getString(@StringRes stringResourceId: Int): String
	
	fun getString(@StringRes resId: Int, vararg formatArgs: Any?): String
	
	fun getStringArray(@ArrayRes stringArrayResourceId: Int): Array<String>
	
	fun getDimension(@DimenRes dimensionResourceId: Int): Float
	
	fun getInteger(@IntegerRes integerResId: Int): Int
	
	fun getDrawable(@DrawableRes drawableResourceId: Int): Drawable?
	
	fun getColor(@ColorRes colorId: Int): Int
	
	fun getBoolean(@BoolRes boolId: Int): Boolean
}