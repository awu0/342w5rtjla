package com.awu0.bookshelf.fake

import com.awu0.bookshelf.data.BookshelfRepository
import com.awu0.bookshelf.model.VolumeItem

class FakeNetworkBookshelfRepository : BookshelfRepository {
    override suspend fun getVolumeItems(): List<VolumeItem> {
        return fakeVolumesResponse.items
    }
}