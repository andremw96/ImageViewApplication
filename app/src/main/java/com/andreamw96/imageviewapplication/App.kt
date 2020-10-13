package com.andreamw96.imageviewapplication

import android.app.Application
import com.andreamw96.data.dotahero.DotaHeroRepository
import com.andreamw96.data.login.LoginRepository
import com.andreamw96.imageviewapplication.datasource.room.AppDatabase
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.di.UseCases
import com.andreamw96.imageviewapplication.feature.dotahero.datasource.MockDotaHeroDataSource
import com.andreamw96.imageviewapplication.feature.login.datasource.RoomUserDataSource
import com.andreamw96.usecases.dotahero.GetAllDotaHeroUseCase
import com.andreamw96.usecases.dotahero.GetDotaHeroUseCase
import com.andreamw96.usecases.login.DeleteUserLoginUseCase
import com.andreamw96.usecases.login.GetUserLoginUseCase
import com.andreamw96.usecases.login.SaveUserLoginUseCase

class App : Application() {

    var appDatabase: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()

        appDatabase = AppDatabase.getAppDataBase(this)

        val loginRepository = LoginRepository(RoomUserDataSource(appDatabase))
        val dotaHeroRepository = DotaHeroRepository(MockDotaHeroDataSource())

        MyViewModelFactory.inject(
            this,
            UseCases(
                GetUserLoginUseCase(loginRepository),
                SaveUserLoginUseCase(loginRepository),
                DeleteUserLoginUseCase(loginRepository),
                GetAllDotaHeroUseCase(dotaHeroRepository),
                GetDotaHeroUseCase(dotaHeroRepository)
            )
        )
    }

}