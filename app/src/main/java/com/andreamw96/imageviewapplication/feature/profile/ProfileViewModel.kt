package com.andreamw96.imageviewapplication.feature.profile

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.andreamw96.imageviewapplication.di.MyViewModel
import com.andreamw96.imageviewapplication.di.UseCases
import com.andreamw96.imageviewapplication.feature.login.datasource.User
import com.andreamw96.imageviewapplication.feature.login.datasource.toPresentationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application,
    useCases: UseCases
) : MyViewModel(application, useCases) {

    val userLogin = MutableLiveData<User>()

    fun deleteUserLogin() {
        GlobalScope.launch(Dispatchers.IO) {
            useCases.deleteUserLoginUseCase()

            val getUser = useCases.getUserLoginUseCase()
            userLogin.postValue(getUser?.toPresentationModel())
        }
    }

}