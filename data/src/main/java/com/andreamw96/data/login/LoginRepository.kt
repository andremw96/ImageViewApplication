package com.andreamw96.data.login

import com.andreamw96.domain.User

class LoginRepository(private val loginUserSource: LoginUserSource) {

    fun getUserLoggedIn(): User? {
        return loginUserSource.getUserLogin()
    }

    fun saveUserLogin(user: User) {
        loginUserSource.saveUserLogin(user)
    }

    fun deleteUserLogin() {
        loginUserSource.deletUserLogin()
    }

}