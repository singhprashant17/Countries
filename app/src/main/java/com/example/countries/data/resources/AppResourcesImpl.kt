package com.example.countries.data.resources

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import javax.inject.Inject

class AppResourcesImpl @Inject constructor(
	override val context: Context
) : AppResources {
	override fun getText(textResourceId: Int): CharSequence {
		return context.getText(textResourceId)
	}
	
	override fun getString(stringResourceId: Int): String {
		return context.getString(stringResourceId)
	}
	
	override fun getString(resId: Int, vararg formatArgs: Any?): String {
		return context.getString(resId, formatArgs)
	}
	
	override fun getStringArray(stringArrayResourceId: Int): Array<String> {
		return context.resources.getStringArray(stringArrayResourceId)
	}
	
	override fun getDimension(dimensionResourceId: Int): Float {
		return context.resources.getDimension(dimensionResourceId)
	}
	
	override fun getInteger(integerResId: Int): Int {
		return context.resources.getInteger(integerResId)
	}
	
	override fun getDrawable(drawableResourceId: Int): Drawable? {
		return ContextCompat.getDrawable(context, drawableResourceId)
	}
	
	override fun getColor(colorId: Int): Int {
		return ContextCompat.getColor(context, colorId)
	}
	
	override fun getBoolean(boolId: Int): Boolean {
		return context.resources.getBoolean(boolId)
	}
}