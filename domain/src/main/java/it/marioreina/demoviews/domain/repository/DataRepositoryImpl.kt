package it.marioreina.demoviews.domain.repository

import com.weredev.retrofitUtils.RetrofitUtils
import com.weredev.retrofitUtils.RetrofitUtils.checkAndParseResponse
import it.marioreina.demoviews.data.model.deal.DealDetailResponse
import it.marioreina.demoviews.data.model.deal.DealResponse
import it.marioreina.demoviews.data.repository.DataRepository
import it.marioreina.demoviews.data.service.RetrofitService

class DataRepositoryImpl(private val retrofitService: RetrofitService): DataRepository {

    override fun getDeals(): MutableList<DealResponse> {
        return RetrofitUtils.execute(retrofitService.getDeals()).checkAndParseResponse()
    }

    override fun getDealDetail(dealId: String): DealDetailResponse {
        return RetrofitUtils.execute(retrofitService.getDealDetails(dealId)).checkAndParseResponse()
    }
}