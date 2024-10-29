package com.awu0.bookshelf.fake

import com.awu0.bookshelf.model.ImageLinks
import com.awu0.bookshelf.model.VolumeInfo
import com.awu0.bookshelf.model.VolumeItem
import com.awu0.bookshelf.model.VolumesResponse

val fakeVolumesResponse = VolumesResponse(
    kind = "books#volumes",
    totalItems = 3,
    items = listOf(
        VolumeItem(
            id = "volume_1",
            volumeInfo = VolumeInfo(
                title = "Fake Book Title 1",
                subtitle = "Subtitle for Fake Book Title 1",
                authors = listOf("Author 3", "Author 3"),
                imageLinks = ImageLinks(
                    thumbnail = "https://fakeimg.pl/150x200/?text=Fake+Book+Title+1",
                    smallThumbnail = "https://fakeimg.pl/100x150/?text=Fake+Book+Title+1",
                    small = "https://fakeimg.pl/200x300/?text=Fake+Book+Title+1",
                    medium = "https://fakeimg.pl/300x450/?text=Fake+Book+Title+1",
                    large = "https://fakeimg.pl/400x600/?text=Fake+Book+Title+1",
                    extraLarge = "https://fakeimg.pl/600x900/?text=Fake+Book+Title+1"
                )
            )
        ),
        VolumeItem(
            id = "volume_2",
            volumeInfo = VolumeInfo(
                title = "Fake Book Title 2",
                subtitle = null,
                authors = listOf("Author 1"),
                imageLinks = ImageLinks(
                    thumbnail = "https://fakeimg.pl/150x200/?text=Fake+Book+Title+2",
                    smallThumbnail = "https://fakeimg.pl/100x150/?text=Fake+Book+Title+2",
                    small = "https://fakeimg.pl/200x300/?text=Fake+Book+Title+2",
                    medium = "https://fakeimg.pl/300x450/?text=Fake+Book+Title+2",
                    large = "https://fakeimg.pl/400x600/?text=Fake+Book+Title+2",
                    extraLarge = "https://fakeimg.pl/600x900/?text=Fake+Book+Title+2"
                )
            )
        ),
        VolumeItem(
            id = "volume_10",
            volumeInfo = VolumeInfo(
                title = "Fake Book Title 10",
                subtitle = "Subtitle for Fake Book Title 10",
                authors = listOf("Author 1", "Author 5"),
                imageLinks = ImageLinks(
                    thumbnail = "https://fakeimg.pl/150x200/?text=Fake+Book+Title+10",
                    smallThumbnail = "https://fakeimg.pl/100x150/?text=Fake+Book+Title+10",
                    small = "https://fakeimg.pl/200x300/?text=Fake+Book+Title+10",
                    medium = "https://fakeimg.pl/300x450/?text=Fake+Book+Title+10",
                    large = "https://fakeimg.pl/400x600/?text=Fake+Book+Title+10",
                    extraLarge = "https://fakeimg.pl/600x900/?text=Fake+Book+Title+10"
                )
            )
        )
    )
)
