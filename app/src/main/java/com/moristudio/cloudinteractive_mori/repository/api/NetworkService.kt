package com.moristudio.cloudinteractive_mori.repository.api

import com.moristudio.cloudinteractive_mori.repository.response.PhotosResponse
import retrofit2.http.*

interface NetworkService {
    @GET("/photos")
    suspend fun getPhotos(): PhotosResponse
}