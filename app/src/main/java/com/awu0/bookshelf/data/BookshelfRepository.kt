package com.awu0.bookshelf.data

import com.awu0.bookshelf.model.VolumeItem
import com.awu0.bookshelf.network.BookshelfApiService

interface BookshelfRepository {
    suspend fun getVolumeItems(): List<VolumeItem>
}

class NetworkBookshelfRepository(
    private val bookshelfApiService: BookshelfApiService
) : BookshelfRepository {
    /** Fetches the books from the bookshelfApi **/
    override suspend fun getVolumeItems(): List<VolumeItem> = bookshelfApiService.getVolumes().items
}