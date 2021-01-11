package com.moristudio.cloudinteractive_mori.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.moristudio.cloudinteractive_mori.base.BaseViewModelFactory
import com.moristudio.cloudinteractive_mori.repository.Repository

class ViewModelFactory(override var mApplication: Application? = null,
                       override var mRepository: Repository? = null) : BaseViewModelFactory() {
    override fun init(application: Application, repository: Repository) {
        mApplication = application
        mRepository = repository
        Log.d("[ViewModelFactory]", "init call.")
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository = mRepository!!)
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            } as T
        }
    }

}