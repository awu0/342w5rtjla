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
class TestBookshelfRepository : BookshelfRepository {
    override suspend fun getBooks(): List<Book> {
        val books : MutableList<Book> = mutableListOf()

        for (i in 1..15) {
            books.add(
                Book(
                    title = "Book Title $i",
                    author = "Author Name $i",
                    thumbnail = "Thumbnail $i"
                )
            )
        }

        return books
    }
}