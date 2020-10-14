package com.andreamw96.imageviewapplication.feature.login

data class LoginFormState (
    var usernameState: String? = null,
    var passwordState: String? = null,
    var validated: Boolean? = false
)