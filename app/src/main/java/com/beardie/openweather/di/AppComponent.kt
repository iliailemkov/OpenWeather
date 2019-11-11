package com.beardie.openweather.di

import android.app.Application
import com.beardie.openweather.BaseApplication
import com.beardie.openweather.di.modules.AppModule
import com.beardie.openweather.di.modules.ViewModelModule
import com.beardie.openweather.di.modules.ViewModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}