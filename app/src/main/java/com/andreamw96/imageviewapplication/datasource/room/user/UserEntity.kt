package com.andreamw96.imageviewapplication.datasource.room.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey
    val email: String
)