package com.andreamw96.imageviewapplication.feature.login.datasource

import com.andreamw96.data.login.LoginUserSource
import com.andreamw96.domain.User
import com.andreamw96.imageviewapplication.room.AppDatabase
import com.andreamw96.imageviewapplication.room.user.UserEntity

class RoomDataSource(private val appDatabase: AppDatabase?) : LoginUserSource {

    private val userDao = appDatabase?.userDao()

    override fun getUserLogin(): User? {
        val userEntityEmail = userDao?.getLoginUser()?.email
        if (userEntityEmail != null) {
            return User(
                userEntityEmail
            )
        }

        return null
    }

    override fun saveUserLogin(user: User) {
        userDao?.saveLoginUser(
            UserEntity(
                user.email
            )
        )
    }

    override fun deletUserLogin() {
        userDao?.deleteLoginUser()
    }
}