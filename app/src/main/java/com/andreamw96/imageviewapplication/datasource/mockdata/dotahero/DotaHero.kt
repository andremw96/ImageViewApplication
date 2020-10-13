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
    val listSkillHero: List<SkillHero>
) : Parcelable

fun DotaHeroDomain.toPresentationModel(): DotaHero {
    return DotaHero(
        this.name,
        this.detail,
        this.photo,
        this.description,
        this.listSkillHero.map {
            SkillHero(it.skill, it.skill_photo_url)
        }
    )
}