package it.marioreina.demoviews.domain.repository

import android.content.SharedPreferences
import it.marioreina.demoviews.data.repository.CacheRepository
import it.marioreina.demoviews.data.utils.SharedPrefConst

class CacheRepositoryImpl(
    private val sharedPreferences: SharedPreferences
): CacheRepository {
    override fun isFirstAccessDone(): Boolean {
        return sharedPreferences.getBoolean(SharedPrefConst.FIRST_ACCESS, false)
    }

    override fun setFirtAccessDone() {
        val editor = sharedPreferences.edit()
        editor.putBoolean(SharedPrefConst.FIRST_ACCESS, true)
        editor.apply()
    }
}