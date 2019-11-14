package com.fobidlim.reflectionmvp.libs

import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.fobidlim.reflectionmvp.libs.qualifiers.RequiresPresenter
import kotlin.reflect.KClass

open class BaseActivity<P : BasePresenter> : AppCompatActivity(), BaseView {

    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignPresenter()
    }

    @CallSuper
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        presenter.intent(intent)
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let {
            presenter.intent(intent)
        }
    }

    private fun assignPresenter() {
        val annotation = javaClass.getAnnotation(RequiresPresenter::class.java)
        val presenterClass = if (annotation == null) null else annotation.value as KClass<P>

        presenterClass?.let {
            createPresenter(presenterClass)?.let { p ->
                presenter = p
            }
        }
    }

    private fun createPresenter(presenterClass: KClass<P>): P? {
        presenterClass.constructors.forEach {
            return it.call(this as BaseView)
                .apply {
                    onCreate()
                }
        }
        return null
    }
}