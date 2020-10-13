package com.andreamw96.data.image

import com.andreamw96.domain.Image

interface ImageDataSource {
    fun getAllImage(): List<Image>
    fun getImage(image: Image): Image
}