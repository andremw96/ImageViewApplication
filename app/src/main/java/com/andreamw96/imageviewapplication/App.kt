package com.andreamw96.imageviewapplication

import android.app.Application
import androidx.room.Delete
import com.andreamw96.data.login.LoginRepository
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.di.UseCases
import com.andreamw96.imageviewapplication.feature.login.datasource.RoomDataSource
import com.andreamw96.imageviewapplication.room.AppDatabase
import com.andreamw96.usecases.login.DeleteUserLoginUseCase
import com.andreamw96.usecases.login.GetUserLoginUseCase
import com.andreamw96.usecases.login.SaveUserLoginUseCase

class App : Application() {

    var appDatabase: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()

        appDatabase = AppDatabase.getAppDataBase(this)

        val loginRepository = LoginRepository(RoomDataSource(appDatabase))

        MyViewModelFactory.inject(
            this,
            UseCases(
                GetUserLoginUseCase(loginRepository),
                SaveUserLoginUseCase(loginRepository),
                DeleteUserLoginUseCase(loginRepository)
            )
        )
    }

}