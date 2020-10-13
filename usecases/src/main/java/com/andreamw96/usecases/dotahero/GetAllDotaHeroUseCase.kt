package com.andreamw96.usecases.dotahero

import com.andreamw96.data.dotahero.DotaHeroRepository
import com.andreamw96.domain.DotaHero

class GetAllDotaHeroUseCase(private val dotaHeroRepository: DotaHeroRepository) {
    operator fun invoke(): List<DotaHero>? = dotaHeroRepository.getAllDotaHero()
}