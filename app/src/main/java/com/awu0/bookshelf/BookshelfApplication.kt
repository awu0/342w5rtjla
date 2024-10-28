package com.awu0.bookshelf

import android.app.Application
import com.awu0.bookshelf.data.AppContainer
import com.awu0.bookshelf.data.DefaultAppContainer

class BookshelfApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}