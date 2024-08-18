package it.marioreina.demoviews.domain.usecase

import com.weredev.usecase.BaseAsyncUseCase
import it.marioreina.demoviews.data.repository.DataRepository
import it.marioreina.demoviews.domain.entity.DealDetailEntity
import it.marioreina.demoviews.domain.entity.toEntity

class GetDealDetailUseCase(
    private val dataRepository: DataRepository
): BaseAsyncUseCase<DealDetailEntity?, String?>() {

    override suspend fun invoke(params: String?): DealDetailEntity {
        return dataRepository.getDealDetail(params!!).toEntity()
    }
}