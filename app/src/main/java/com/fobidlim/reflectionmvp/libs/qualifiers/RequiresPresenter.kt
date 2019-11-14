package com.fobidlim.reflectionmvp.libs.qualifiers

import com.fobidlim.reflectionmvp.libs.BasePresenter
import java.lang.annotation.Inherited
import kotlin.reflect.KClass

@Inherited
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiresPresenter(
    val value: KClass<out BasePresenter>
)