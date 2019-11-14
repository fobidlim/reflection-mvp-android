package com.fobidlim.reflectionmvp.libs

import android.content.Intent
import android.util.Log
import androidx.annotation.CallSuper

open class BasePresenter(private val view: BaseView) {

    private lateinit var intent: Intent

    @CallSuper
    open fun onCreate() {
        Log.d(javaClass.simpleName, "onCreate ${toString()}")
    }

    open fun intent(intent: Intent) {
        this.intent = intent
    }

    @CallSuper
    fun onStart() {
        Log.d(javaClass.simpleName, "onStart ${toString()}")
    }

    @CallSuper
    fun onResume() {
        Log.d(javaClass.simpleName, "onResume ${toString()}")
    }

    @CallSuper
    fun onPause() {
        Log.d(javaClass.simpleName, "onPause ${toString()}")
    }

    @CallSuper
    fun onStop() {
        Log.d(javaClass.simpleName, "onStop ${toString()}")
    }

    @CallSuper
    fun onDestroy() {
        Log.d(javaClass.simpleName, "onDestroy ${toString()}")
    }
}