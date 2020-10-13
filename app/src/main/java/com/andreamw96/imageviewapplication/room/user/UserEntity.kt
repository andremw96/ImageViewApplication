package com.andreamw96.imageviewapplication.room.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey
    val email: String
)