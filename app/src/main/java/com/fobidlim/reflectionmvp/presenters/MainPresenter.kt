package com.fobidlim.reflectionmvp.presenters

import com.fobidlim.reflectionmvp.libs.BasePresenter
import com.fobidlim.reflectionmvp.views.MainView

class MainPresenter(
    private val view: MainView
) : BasePresenter(view) {

    override fun onCreate() {
        super.onCreate()

        view.showToast("Hello world!")
    }

    fun buttonClicked() {
        view.showSecond("Welcome to second!")
    }
}