package com.awu0.bookshelf.data

interface AppContainer {
    val bookshelfRepository: BookshelfRepository
}

class DefaultAppContainer : AppContainer {
    // TODO: put retrofit here

    // temp getting repo
    override val bookshelfRepository: BookshelfRepository
        get() = TestBookshelfRepository()
}