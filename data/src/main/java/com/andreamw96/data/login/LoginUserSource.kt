package com.andreamw96.data.login

import com.andreamw96.domain.User

interface LoginUserSource {
    fun getUserLogin(): User?
    fun saveUserLogin(user: User)
    fun deletUserLogin()
}