package com.andreamw96.imageviewapplication.datasource.mockdata.dotahero

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.andreamw96.domain.DotaHero as DotaHeroDomain

@Parcelize
data class DotaHero(
    val name: String,
    val detail: String,
    val photo: String,
    val description: String,
    val skill_1: String,
    val skill_2: String,
    val skill_3: String,
    val skill_4: String
) : Parcelable

fun DotaHeroDomain.toPresentationModel(): DotaHero {
    return DotaHero(
        this.name,
        this.detail,
        this.photo,
        this.description,
        this.skill_1,
        this.skill_2,
        this.skill_3,
        this.skill_4
    )
}