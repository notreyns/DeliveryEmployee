package com.example.evergreenclient.data.localDatabase

import android.content.Context
import android.content.SharedPreferences
import org.koin.core.component.KoinComponent

class LocalDatabase(context : Context) : KoinComponent {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("TestApp", Context.MODE_PRIVATE)

    private val editor = prefs.edit()

    companion object {

        const val USER_ROLE = "role"
        const val ACCESS = "access"
        const val REFRESH = "refresh"
    }

    fun saveUserRole(name: String?){
        if (name != null){
            editor.putString(USER_ROLE,name).apply()
        }
    }

    fun saveAccessToken(token: String?) {
        editor.putString(ACCESS, token)
        editor.apply()
    }

    fun saveRefreshToken(token: String?) {
        editor.putString(REFRESH, token)
        editor.apply()
    }

    fun fetchUserRole():String? {
        return prefs.getString(USER_ROLE, null)
    }

    fun fetchAccessToken(): String? {
        return prefs.getString(ACCESS, null)
    }

    fun fetchRefreshToken(): String? {
        return prefs.getString(REFRESH, null)
    }

    fun clearData() {
        editor.clear().apply()

    }
}