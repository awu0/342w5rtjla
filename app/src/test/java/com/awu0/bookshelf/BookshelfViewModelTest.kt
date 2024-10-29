package com.awu0.bookshelf

import com.awu0.bookshelf.fake.FakeNetworkBookshelfRepository
import com.awu0.bookshelf.fake.fakeVolumesResponse
import com.awu0.bookshelf.rules.TestDispatcherRule
import com.awu0.bookshelf.ui.screens.BookshelfUiState
import com.awu0.bookshelf.ui.screens.BookshelfViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BookshelfViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun bookshelfViewModel_getBooks_verifyBookshelfUiStateSuccess() = runTest {
        val bookshelfViewModel = BookshelfViewModel(
            bookshelfRepository = FakeNetworkBookshelfRepository()
        )

        assertEquals(
            BookshelfUiState.Success(fakeVolumesResponse.items),
            bookshelfViewModel.bookshelfUiState
        )
    }
}