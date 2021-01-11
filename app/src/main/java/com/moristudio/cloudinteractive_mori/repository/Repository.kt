package com.moristudio.cloudinteractive_mori.repository

import com.moristudio.cloudinteractive_mori.repository.api.NetworkService
import com.moristudio.cloudinteractive_mori.repository.response.PhotosResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val networkService: NetworkService) {

    fun getPhotosResult(): Flow<ViewState<PhotosResponse>> {
        return flow {
            emit(ViewState.loading())
            val result = networkService.getPhotos()
            emit(ViewState.success(result))
        }.catch {
            emit(ViewState.error(it.message.orEmpty()))
        }.flowOn(Dispatchers.IO)
    }

}