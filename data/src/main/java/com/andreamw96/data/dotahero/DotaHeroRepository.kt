package com.andreamw96.data.dotahero

import com.andreamw96.domain.DotaHero

class DotaHeroRepository(private val dotaHeroDataSource: DotaHeroDataSource) {

    fun getAllDotaHero(): List<DotaHero>? {
        return dotaHeroDataSource.getAllDotaHero()
    }

    fun getDotaHero(hero: DotaHero): DotaHero? {
        return dotaHeroDataSource.getDotaHero(hero)
    }

}