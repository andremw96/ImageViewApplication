package com.andreamw96.imageviewapplication.feature.login.datasource

import com.andreamw96.domain.User as DomainUserClass

data class User (
    val email: String
)

fun DomainUserClass.toPresentationModel(): User = User(
    this.email
)