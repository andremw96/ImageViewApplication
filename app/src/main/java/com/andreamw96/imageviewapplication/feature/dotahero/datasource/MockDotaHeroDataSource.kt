package com.andreamw96.imageviewapplication.feature.dotahero.datasource

import com.andreamw96.data.dotahero.DotaHeroDataSource
import com.andreamw96.imageviewapplication.datasource.mockdata.dotahero.DotaHeroMockData
import com.andreamw96.domain.DotaHero as DotaHeroDomain

class MockDotaHeroDataSource() : DotaHeroDataSource {

    override fun getAllDotaHero(): List<DotaHeroDomain> {
        return DotaHeroMockData.dataDotaHero
    }

    override fun getDotaHero(hero: DotaHeroDomain): DotaHeroDomain? {
        return DotaHeroMockData.dataDotaHero.find {
            it.name == hero.name
        }
    }


}