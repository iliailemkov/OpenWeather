package com.beardie.openweather.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)