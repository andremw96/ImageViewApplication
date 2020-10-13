package com.andreamw96.usecases.login

import com.andreamw96.data.login.LoginRepository
import com.andreamw96.domain.User

class SaveUserLoginUseCase(private val loginRepository: LoginRepository) {
    operator fun invoke(user: User) = loginRepository.saveUserLogin(user)
}