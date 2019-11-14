package com.fobidlim.reflectionmvp.presenters

import android.content.Intent
import com.fobidlim.reflectionmvp.libs.BasePresenter
import com.fobidlim.reflectionmvp.ui.IntentKey
import com.fobidlim.reflectionmvp.views.SecondView

class SecondPresenter(
    private val view: SecondView
) : BasePresenter(view) {

    override fun intent(intent: Intent) {
        super.intent(intent)

        (intent.getStringExtra(IntentKey.KEY_MESSAGE) ?: "message not found!").let {
            view.setMessageText(it)
        }
    }
}