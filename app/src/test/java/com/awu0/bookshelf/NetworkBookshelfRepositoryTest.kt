package com.awu0.bookshelf

import com.awu0.bookshelf.data.NetworkBookshelfRepository
import com.awu0.bookshelf.fake.FakeBookshelfApiService
import com.awu0.bookshelf.fake.fakeVolumesResponse
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBookshelfRepositoryTest {
    @Test
    fun networkBookRepository_getVolumeItems_verifyVolumeItems() = runTest {
        val repository = NetworkBookshelfRepository(bookshelfApiService = FakeBookshelfApiService())

        assertEquals(fakeVolumesResponse.items, repository.getVolumeItems())
    }
}