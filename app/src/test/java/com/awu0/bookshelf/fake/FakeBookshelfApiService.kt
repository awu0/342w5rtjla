package com.awu0.bookshelf.fake

import com.awu0.bookshelf.model.VolumesResponse
import com.awu0.bookshelf.network.BookshelfApiService

class FakeBookshelfApiService : BookshelfApiService {
    override suspend fun getVolumes(): VolumesResponse {
        return fakeVolumesResponse
    }
}