package com.andreamw96.imageviewapplication.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.andreamw96.imageviewapplication.App

open class MyViewModel(application: Application, protected val useCases: UseCases): AndroidViewModel(application) {

    protected val application: App = getApplication()

}