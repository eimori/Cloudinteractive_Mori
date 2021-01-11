package com.moristudio.cloudinteractive_mori.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SampleAPI : BaseAPI() {

    companion object {
        private val TAG = SampleAPI::class.simpleName
        private var sInstance: SampleAPI? = null
        private lateinit var mService: NetworkService

        fun getInstance(): SampleAPI? {
            if (sInstance == null) {
                synchronized(SampleAPI::class) {
                    if (sInstance == null) {
                        sInstance = SampleAPI()
                    }
                }
            }
            return sInstance
        }
    }

    init {
        val url = "https://jsonplaceholder.typicode.com"
        val okHttpClient = getOkHttpClient()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient!!)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mService = retrofit.create(NetworkService::class.java)
    }

    fun getService(): NetworkService = mService

}