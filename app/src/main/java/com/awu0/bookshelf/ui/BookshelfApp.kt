package com.awu0.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.awu0.bookshelf.ui.screens.BookshelfViewModel
import com.awu0.bookshelf.ui.screens.HomeScreen

@Composable
fun BookshelfApp() {
    Scaffold(
        topBar = { }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val bookshelfViewModel: BookshelfViewModel =
                viewModel(factory = BookshelfViewModel.Factory)

            HomeScreen(
                bookshelfUiState = bookshelfViewModel.bookshelfUiState,
                contentPadding = it
            )
        }
    }

}