package it.marioreina.demoviews.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import it.marioreina.demoviews.data.service.RetrofitService
import it.marioreina.demoviews.data.utils.KoinConst
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getDataModule(): Module {

    val dataModule = module {

        single<OkHttpClient> {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
                .build()
        }

        single<Gson> {
            GsonBuilder()
                .setLenient()
                .create()
        }

        single<Retrofit>(named(KoinConst.KOIN_RETROFIT)) {
            Retrofit.Builder()
                .client(get())
                .baseUrl(KoinConst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
        }

        single<RetrofitService> {
            val retrofit : Retrofit by inject(named(KoinConst.KOIN_RETROFIT))
            retrofit.create(RetrofitService::class.java)
        }
    }
    return dataModule
}