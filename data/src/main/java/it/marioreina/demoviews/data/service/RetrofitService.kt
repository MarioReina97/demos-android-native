package it.marioreina.demoviews.data.service

import it.marioreina.demoviews.data.model.deal.DealDetailResponse
import it.marioreina.demoviews.data.model.deal.DealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/api/1.0/deals")
    fun getDeals(): Call<MutableList<DealResponse>>

    @GET("/api/1.0/deals")
    fun getDealDetails(@Query("id") dealId: String): Call<DealDetailResponse>


}