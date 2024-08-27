package it.marioreina.demoviews.domain.di

import it.marioreina.demoviews.data.di.getDataModule
import it.marioreina.demoviews.data.repository.CacheRepository
import it.marioreina.demoviews.data.repository.DataRepository
import it.marioreina.demoviews.data.utils.KoinConst
import it.marioreina.demoviews.domain.repository.CacheRepositoryImpl
import it.marioreina.demoviews.domain.repository.DataRepositoryImpl
import it.marioreina.demoviews.domain.usecase.GetDealDetailUseCase
import it.marioreina.demoviews.domain.usecase.GetDealsUseCase
import it.marioreina.demoviews.domain.usecase.IsFirstAccessDoneUseCase
import it.marioreina.demoviews.domain.usecase.SetFirstAccessDoneUseCase
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun getDomainModule(): List<Module> {

    val domainModule = module {
        single<DataRepository> { DataRepositoryImpl(get()) }
        single<CacheRepository> { CacheRepositoryImpl(get(named(KoinConst.KOIN_SHARED_PREFF))) }
        factory { GetDealsUseCase(get()) }
        factory { GetDealDetailUseCase(get()) }
        factory { IsFirstAccessDoneUseCase(get()) }
        factory { SetFirstAccessDoneUseCase(get()) }
    }
    return domainModule + getDataModule()
}