package it.marioreina.demoviews.domain.usecase

import com.weredev.usecase.BaseAsyncUseCase
import it.marioreina.demoviews.data.repository.DataRepository
import it.marioreina.demoviews.domain.entity.DealEntity
import it.marioreina.demoviews.domain.entity.toEntity

class GetDealsUseCase(
    private val dataRepository: DataRepository
): BaseAsyncUseCase<MutableList<DealEntity>?, Unit?>() {

    override suspend fun invoke(params: Unit?): MutableList<DealEntity> {
        return dataRepository.getDeals().filter {
            !it.steamAppID.isNullOrBlank()
        }.toMutableList().toEntity()
    }
}