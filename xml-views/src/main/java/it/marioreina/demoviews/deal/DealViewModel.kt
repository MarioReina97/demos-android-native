package it.marioreina.demoviews.deal

import androidx.lifecycle.MutableLiveData
import com.weredev.usecase.BaseViewModel
import com.weredev.usecase.executeAndDispose
import com.weredev.usecase.executeWithCatch
import com.weredev.usecase.utils.Resource
import it.marioreina.demoviews.domain.entity.DealDetailEntity
import it.marioreina.demoviews.domain.entity.DealEntity
import it.marioreina.demoviews.domain.usecase.GetDealDetailUseCase
import it.marioreina.demoviews.domain.usecase.GetDealsUseCase
import it.marioreina.demoviews.domain.usecase.IsFirstAccessDoneUseCase

class DealViewModel(
    private val getDealsUseCase: GetDealsUseCase,
    private val getDealDetailUseCase: GetDealDetailUseCase,
    private val isFirstAccessDoneUseCase: IsFirstAccessDoneUseCase,
): BaseViewModel() {

    val dealEntityListLiveData: MutableLiveData<Resource<MutableList<DealEntity>?>> = MutableLiveData()
    val dealDetailEntityLiveData: MutableLiveData<Resource<DealDetailEntity?>> = MutableLiveData()
    val isFirstAccessLiveData: MutableLiveData<Resource<Boolean?>> = MutableLiveData()

    fun getDeals() {
        getDealsUseCase.executeAndDispose(mutableLiveData = dealEntityListLiveData, null)
    }

    fun getDealDetail(dealId: String) {
        getDealDetailUseCase.executeAndDispose(dealDetailEntityLiveData, dealId)
    }

    fun isFirstAccess() {
        isFirstAccessDoneUseCase.executeAndDispose(isFirstAccessLiveData)
    }
}