package it.marioreina.demoviews.domain.usecase

import com.weredev.usecase.BaseSyncUseCase
import it.marioreina.demoviews.data.repository.CacheRepository

class SetFirstAccessDoneUseCase(
    private val cacheRepository: CacheRepository
): BaseSyncUseCase<Unit, Unit?>() {
    override fun invoke(params: Unit?): Unit {
        cacheRepository.setFirtAccessDone()
    }
}