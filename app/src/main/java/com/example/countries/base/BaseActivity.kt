package com.example.countries.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.countries.BR
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
	
	abstract val viewModel: BaseViewModel?
	abstract val contentViewBinding: ViewDataBinding?
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		performSetContentView()
	}
	
	protected fun performSetContentView() {
		setContentView(contentViewBinding?.root)
		contentViewBinding?.lifecycleOwner = this
		contentViewBinding?.setVariable(BR.viewModel, viewModel)
	}
	
	override fun onStart() {
		super.onStart()
		attachToLiveData()
	}
	
	protected fun attachToLiveData() {
		viewModel?.callbacks?.observe(this, Observer { callbackAction ->
			onCallbackInvoked(callbackAction)
		})
	}
	
	protected open fun onCallbackInvoked(oneTimeCallbackAction: OneTimeCallbackAction?) {
		when (oneTimeCallbackAction) {
			is SnackBarMessage -> {
				oneTimeCallbackAction.message
					?.takeIf { it.isBlank().not() && contentViewBinding != null }
					?.let {
						Snackbar.make(contentViewBinding!!.root, it, Snackbar.LENGTH_SHORT).show()
					}
			}
		}
	}
}