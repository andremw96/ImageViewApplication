package com.andreamw96.imageviewapplication.feature.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.andreamw96.imageviewapplication.di.MyViewModel
import com.andreamw96.imageviewapplication.di.UseCases
import com.andreamw96.imageviewapplication.feature.login.datasource.User
import com.andreamw96.imageviewapplication.feature.login.datasource.toPresentationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.andreamw96.domain.User as DomainUser

class LoginViewModel(
    application: Application,
    useCases: UseCases
) : MyViewModel(application, useCases) {

    val userLogin = MutableLiveData<User>()

    fun getUserLogin() {
        GlobalScope.launch(Dispatchers.Main) {
            val getUser = withContext(Dispatchers.IO) {
                useCases.getUserLoginUseCase()
            }
            userLogin.postValue(getUser?.toPresentationModel())
        }
    }

    fun saveUserLogin(email: String) {
        GlobalScope.launch(Dispatchers.IO) {
            useCases.saveUserLoginUseCase(DomainUser(email))

            val getUser = useCases.getUserLoginUseCase()
            userLogin.postValue(getUser?.toPresentationModel())
        }
    }
}