package com.fobidlim.reflectionmvp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.CallSuper
import com.fobidlim.reflectionmvp.R
import com.fobidlim.reflectionmvp.libs.BaseActivity
import com.fobidlim.reflectionmvp.libs.qualifiers.RequiresPresenter
import com.fobidlim.reflectionmvp.presenters.MainPresenter
import com.fobidlim.reflectionmvp.ui.IntentKey
import com.fobidlim.reflectionmvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

@RequiresPresenter(MainPresenter::class)
class MainActivity : BaseActivity<MainPresenter>(), MainView {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            presenter.buttonClicked()
        }
    }

    override fun showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun showSecond(message: String) =
        Intent(this, SecondActivity::class.java)
            .apply {
                putExtra(IntentKey.KEY_MESSAGE, message)
            }.let {
                startActivity(it)
            }
}
