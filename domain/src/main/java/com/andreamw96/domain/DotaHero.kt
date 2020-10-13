package com.andreamw96.domain

data class DotaHero(
    val name: String,
    val detail: String,
    val photo: String,
    val description: String,
    val listSkillHero: List<SkillHero>
)

