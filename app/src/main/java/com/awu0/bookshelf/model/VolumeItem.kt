package com.awu0.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeItem(
    val id: String,
    val volumeInfo: VolumeInfo
)