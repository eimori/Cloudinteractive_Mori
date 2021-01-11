package com.moristudio.cloudinteractive_mori.base

import android.app.Activity
import android.app.Application
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.moristudio.cloudinteractive_mori.repository.Repository
import com.moristudio.cloudinteractive_mori.repository.api.BaseAPI
import com.moristudio.cloudinteractive_mori.repository.api.SampleAPI

object AppInjector {

    private lateinit var application: Application
    private lateinit var viewModelFactory: BaseViewModelFactory
    private lateinit var repository: Repository

    fun init(application: Application, factory: BaseViewModelFactory) {
        AppInjector.application = application
        AppInjector.application.let {
            BaseAPI.init(application)
            repository = Repository(SampleAPI.getInstance()?.getService()!!)
            factory.init(application, repository)
            viewModelFactory = factory
        }
    }

    inline fun <reified T : ViewModel> obtainViewModel(activity: Activity): T =
        ViewModelProvider(activity as AppCompatActivity,
            getViewModelFactory()
        ).get(T::class.java)

    inline fun <reified T : ViewModel> obtainViewModel(fragment: Fragment): T =
        ViewModelProvider(fragment,
            getViewModelFactory()
        ).get(T::class.java)

    fun getViewModelFactory():BaseViewModelFactory = viewModelFactory
}