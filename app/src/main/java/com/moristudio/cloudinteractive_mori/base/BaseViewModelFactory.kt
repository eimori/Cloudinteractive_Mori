package com.moristudio.cloudinteractive_mori.base

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.moristudio.cloudinteractive_mori.repository.Repository

abstract class BaseViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    abstract var mApplication: Application?
    abstract var mRepository: Repository?

    abstract fun init(application: Application, repository: Repository)

}