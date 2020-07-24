package com.example.countries.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.countries.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
	private val privateOneTimeCallback: SingleLiveEvent<OneTimeCallbackAction> = SingleLiveEvent()
	val callbacks: LiveData<OneTimeCallbackAction> = privateOneTimeCallback
	
	protected val compositeDisposable = CompositeDisposable()
	
	protected fun sendActions(oneTimeCallbackAction: OneTimeCallbackAction?) {
		privateOneTimeCallback.value = oneTimeCallbackAction
	}
	
	override fun onCleared() {
		compositeDisposable.dispose()
		super.onCleared()
	}
}

interface OneTimeCallbackAction
class SnackBarMessage(val message: String?) : OneTimeCallbackAction