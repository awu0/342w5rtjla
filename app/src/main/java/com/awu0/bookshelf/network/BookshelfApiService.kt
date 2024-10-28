package com.awu0.bookshelf.network

import com.awu0.bookshelf.model.VolumesResponse
import retrofit2.http.GET

interface BookshelfApiService {
    @GET("books/v1/volumes?q=light%20novel&maxResults=40")
    suspend fun getVolumes(): VolumesResponse
}