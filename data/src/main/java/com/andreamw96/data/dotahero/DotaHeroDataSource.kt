package com.andreamw96.data.dotahero

import com.andreamw96.domain.DotaHero

interface DotaHeroDataSource {
    fun getAllDotaHero(): List<DotaHero>
    fun getDotaHero(hero: DotaHero): DotaHero?
}