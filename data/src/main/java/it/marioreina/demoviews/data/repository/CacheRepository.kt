package it.marioreina.demoviews.data.repository

interface CacheRepository {

    fun isFirstAccessDone(): Boolean

    fun setFirtAccessDone()
}