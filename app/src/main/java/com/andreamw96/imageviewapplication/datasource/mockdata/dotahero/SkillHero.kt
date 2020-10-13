package com.andreamw96.imageviewapplication.datasource.mockdata.dotahero

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SkillHero(
    val skill: String,
    val skill_photo_url: String
): Parcelable