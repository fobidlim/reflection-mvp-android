package com.fobidlim.reflectionmvp.views

import com.fobidlim.reflectionmvp.libs.BaseView

interface MainView : BaseView {

    fun showToast(message: String)
    fun showSecond(message: String)
}