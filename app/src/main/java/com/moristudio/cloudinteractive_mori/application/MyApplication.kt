package com.moristudio.cloudinteractive_mori.application

import android.app.Application
import com.moristudio.cloudinteractive_mori.base.AppInjector
import com.moristudio.cloudinteractive_mori.viewmodel.ViewModelFactory

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this, ViewModelFactory())
    }

}