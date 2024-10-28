package com.awu0.bookshelf.data

import com.awu0.bookshelf.model.Book

interface BookshelfRepository {
    suspend fun getBooks(): List<Book>
}

class NetworkBookshelfRepository(
    // api service
) : BookshelfRepository {
    override suspend fun getBooks(): List<Book> {
        TODO("Not yet implemented")
    }
}

/**
 * temp; for testing
 */
class LocalBookshelfRepository : BookshelfRepository {
    override suspend fun getBooks(): List<Book> {
        val book = Book(title = "My Book Title", author = "Author Name", thumbnail = "picture")
        return listOf(book)
    }
}