package com.andreamw96.imageviewapplication.feature.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.andreamw96.imageviewapplication.R
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

    var loginState = MutableLiveData<LoginFormState>()
    val userLogin = MutableLiveData<User>()

    fun login(email: String?, password: String?) {
        when {
            email.isNullOrEmpty() -> {
                loginState.postValue(LoginFormState(application.getString(R.string.email_must_be_filled)))
            }
            password.isNullOrEmpty() -> {
                loginState.postValue(LoginFormState(passwordState = application.getString(R.string.pwd_must_be_filled)))
            }
            else -> {
                loginState.postValue(LoginFormState(validated = true))
            }
        }
    }

    fun getUserLogin() {
        GlobalScope.launch(Dispatchers.Main) {
            val getUser = withContext(Dispatchers.IO) {
                useCases.getUserLoginUseCase()
            }
            userLogin.postValue(getUser?.toPresentationModel())
        }
    }

    fun saveUserLogin(email: String) {
        if (loginState.value?.validated == true) {
            GlobalScope.launch(Dispatchers.IO) {
                useCases.saveUserLoginUseCase(DomainUser(email))

                val getUser = useCases.getUserLoginUseCase()
                userLogin.postValue(getUser?.toPresentationModel())
            }
        }
    }
}