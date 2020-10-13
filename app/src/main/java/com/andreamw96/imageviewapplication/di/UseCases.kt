package com.andreamw96.imageviewapplication.di

import com.andreamw96.usecases.dotahero.GetAllDotaHeroUseCase
import com.andreamw96.usecases.dotahero.GetDotaHeroUseCase
import com.andreamw96.usecases.login.DeleteUserLoginUseCase
import com.andreamw96.usecases.login.GetUserLoginUseCase
import com.andreamw96.usecases.login.SaveUserLoginUseCase

data class UseCases(
    val getUserLoginUseCase: GetUserLoginUseCase,
    val saveUserLoginUseCase: SaveUserLoginUseCase,
    val deleteUserLoginUseCase: DeleteUserLoginUseCase,
    val getAllDotaHeroUseCase: GetAllDotaHeroUseCase,
    val getDotaHeroUseCase: GetDotaHeroUseCase
)