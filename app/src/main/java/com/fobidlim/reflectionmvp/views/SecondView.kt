package com.fobidlim.reflectionmvp.views

import com.fobidlim.reflectionmvp.libs.BaseView

interface SecondView : BaseView {

    fun setMessageText(message: String)
}