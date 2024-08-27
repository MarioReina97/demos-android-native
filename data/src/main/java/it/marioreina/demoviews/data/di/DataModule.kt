package it.marioreina.demoviews.data.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import it.marioreina.demoviews.data.service.RetrofitService
import it.marioreina.demoviews.data.utils.KoinConst
import it.marioreina.demoviews.data.utils.SharedPrefConst.SHARED_NAME
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getDataModule(): Module {

    val dataModule = module {
        //REMOTE
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

        //SHARED
        single<SharedPreferences>(named(KoinConst.KOIN_SHARED_PREFF)) {
            androidContext().getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
        }
    }
    return dataModule
}