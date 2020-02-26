package com.marcin.wac.mvvmv2.utilities.persistence

import android.content.Context
import com.marcin.wac.mvvmv2.utilities.BaseStorage
import javax.inject.Inject

open class UserSession @Inject constructor(context: Context)
    : BaseStorage(context), IUserSession {
    override fun logIn(accessToken: String) {
    }

    override fun logOut() {
    }

    override fun getToken(): String {
        return ""
    }

    override fun getStorageName(): String {
        return ""
    }
}