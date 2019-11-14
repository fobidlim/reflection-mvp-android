package com.fobidlim.reflectionmvp.ui.activities

import android.os.Bundle
import com.fobidlim.reflectionmvp.R
import com.fobidlim.reflectionmvp.libs.BaseActivity
import com.fobidlim.reflectionmvp.libs.qualifiers.RequiresPresenter
import com.fobidlim.reflectionmvp.presenters.SecondPresenter
import com.fobidlim.reflectionmvp.views.SecondView
import kotlinx.android.synthetic.main.activity_second.*

@RequiresPresenter(SecondPresenter::class)
class SecondActivity : BaseActivity<SecondPresenter>(), SecondView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun setMessageText(message: String) {
        this.message.text = message
    }
}