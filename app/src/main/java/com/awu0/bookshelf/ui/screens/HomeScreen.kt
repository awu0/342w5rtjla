package com.awu0.bookshelf.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.awu0.bookshelf.model.VolumeInfo
import com.awu0.bookshelf.model.VolumeItem

@Composable
fun HomeScreen(
    bookshelfUiState: BookshelfUiState,
    modifier: Modifier = Modifier,
) {
    when (bookshelfUiState) {
        is BookshelfUiState.Loading -> Text("Loading")

        is BookshelfUiState.Success -> BookshelfGridScreen(bookshelfUiState.volumeItems, modifier)

        is BookshelfUiState.Error -> Text("Error")
    }
}

@Composable
fun BookshelfGridScreen(
    volumeItems: List<VolumeItem>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding
    ) {
        items(items = volumeItems, key = { volumeItem -> volumeItem.id}) { volumeItem ->
            val book : VolumeInfo = volumeItem.volumeInfo

            Column {
                Text(book.title)

                if (book.authors.isNullOrEmpty()) {
                    Text("Authors: Unknown")
                } else {
                    Text("Authors: ${book.authors.joinToString(", ")}")
                }
            }
        }
    }
}