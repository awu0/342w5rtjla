package com.awu0.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.awu0.bookshelf.BookshelfApplication
import com.awu0.bookshelf.data.BookshelfRepository
import com.awu0.bookshelf.model.Book
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BookshelfUiState {
    data class Success(val books: List<Book>) : BookshelfUiState
    data object Loading : BookshelfUiState
    data object Error : BookshelfUiState
}

class BookshelfViewModel(
    val bookshelfRepository: BookshelfRepository
) : ViewModel() {
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    init {
        getBooks()
    }

    /**
     * Gets all the books
     */
    fun getBooks() {
        viewModelScope.launch {
            bookshelfUiState = BookshelfUiState.Loading

            // make a request to get the books
            bookshelfUiState = try {
                val result = bookshelfRepository.getBooks()
                BookshelfUiState.Success(result)
            } catch (e: IOException) {
                BookshelfUiState.Error
            }
        }
    }

    /**
     * Factory for [BookshelfViewModel] that takes [BookshelfRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val bookshelfRepository = application.container.bookshelfRepository

                BookshelfViewModel(bookshelfRepository = bookshelfRepository)
            }
        }
    }
}