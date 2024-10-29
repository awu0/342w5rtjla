package com.awu0.bookshelf.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.awu0.bookshelf.R
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
fun BookCoverCard(
    book: VolumeInfo,
    modifier: Modifier = Modifier
) {
    // the url has to be https, not http
    val thumbnailUrl = book.imageLinks?.thumbnail?.replace("http", "https")

    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(thumbnailUrl)
            .crossfade(true)
            .build(),
        error = painterResource(R.drawable.ic_broken_image),
        placeholder = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.book_thumbnail),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth()
    )

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
        items(items = volumeItems, key = { volumeItem -> volumeItem.id }) { volumeItem ->
            val book: VolumeInfo = volumeItem.volumeInfo

            Column(
                modifier = modifier.padding(bottom = 16.dp)
            ) {
                BookCoverCard(
                    book,
                    modifier = modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .aspectRatio(3 / 4.5f)
                )

                Text(book.title, fontWeight = FontWeight.Bold)

                if (!book.subtitle.isNullOrEmpty()) {
                    Text(book.subtitle, fontWeight = FontWeight.Bold)
                }

                if (book.authors.isNullOrEmpty()) {
                    Text("Authors: Unknown")
                } else {
                    Text("Authors: ${book.authors.joinToString(", ")}")
                }
            }
        }
    }
}