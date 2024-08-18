package it.marioreina.demoviews.domain.di

import it.marioreina.demoviews.data.di.getDataModule
import it.marioreina.demoviews.data.repository.DataRepository
import it.marioreina.demoviews.domain.repository.DataRepositoryImpl
import it.marioreina.demoviews.domain.usecase.GetDealDetailUseCase
import it.marioreina.demoviews.domain.usecase.GetDealsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDomainModule(): List<Module> {

    val domainModule = module {
        single<DataRepository> { DataRepositoryImpl(get()) }

        factory {
            GetDealsUseCase(get())
        }
        factory {
            GetDealDetailUseCase(get())
        }
    }
    return domainModule + getDataModule()
}