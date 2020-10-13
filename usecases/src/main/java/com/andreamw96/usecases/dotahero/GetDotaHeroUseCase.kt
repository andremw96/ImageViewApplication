package com.andreamw96.usecases.dotahero

import com.andreamw96.data.dotahero.DotaHeroRepository
import com.andreamw96.domain.DotaHero

class GetDotaHeroUseCase(private val dotaHeroRepository: DotaHeroRepository) {
    operator fun invoke(hero: DotaHero): DotaHero? = dotaHeroRepository.getDotaHero(hero)
}