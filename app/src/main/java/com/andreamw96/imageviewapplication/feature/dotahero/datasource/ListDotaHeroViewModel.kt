package com.andreamw96.imageviewapplication.feature.dotahero.datasource

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.andreamw96.imageviewapplication.datasource.mockdata.dotahero.DotaHero
import com.andreamw96.imageviewapplication.datasource.mockdata.dotahero.toPresentationModel
import com.andreamw96.imageviewapplication.di.MyViewModel
import com.andreamw96.imageviewapplication.di.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListDotaHeroViewModel(
    application: Application,
    useCases: UseCases
) : MyViewModel(application, useCases) {

    val listDotaHero = MutableLiveData<List<DotaHero>>()

    fun getAllDotaHero() {
        GlobalScope.launch(Dispatchers.IO) {
            val data = useCases.getAllDotaHeroUseCase()

            listDotaHero.postValue(
                data?.map {
                    it.toPresentationModel()
                }
            )
        }
    }

}