package it.marioreina.demoviews.data.repository

import it.marioreina.demoviews.data.model.deal.DealDetailResponse
import it.marioreina.demoviews.data.model.deal.DealResponse

interface DataRepository {

    fun getDeals(): MutableList<DealResponse>

    fun getDealDetail(dealId: String): DealDetailResponse

}