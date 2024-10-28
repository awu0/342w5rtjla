package com.awu0.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumesResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<VolumeItem>
)
