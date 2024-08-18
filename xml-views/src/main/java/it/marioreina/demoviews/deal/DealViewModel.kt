package it.marioreina.demoviews.deal

import androidx.lifecycle.MutableLiveData
import com.weredev.usecase.BaseViewModel
import com.weredev.usecase.utils.Resource
import it.marioreina.demoviews.domain.entity.DealDetailEntity
import it.marioreina.demoviews.domain.entity.DealEntity
import it.marioreina.demoviews.domain.usecase.GetDealDetailUseCase
import it.marioreina.demoviews.domain.usecase.GetDealsUseCase

class DealViewModel(
    private val getDealsUseCase: GetDealsUseCase,
    private val getDealDetailUseCase: GetDealDetailUseCase
): BaseViewModel() {

    val dealEntityListLiveData: MutableLiveData<Resource<MutableList<DealEntity>?>> = MutableLiveData()
    val dealDetailEntityLiveData: MutableLiveData<Resource<DealDetailEntity?>> = MutableLiveData()

    fun getDeals() {
        getDealsUseCase.executeAndDispose(mutableLiveData = dealEntityListLiveData, null)
    }

    fun getDealDetail(dealId: String) {
        getDealDetailUseCase.executeAndDispose(dealDetailEntityLiveData, dealId)
    }

}