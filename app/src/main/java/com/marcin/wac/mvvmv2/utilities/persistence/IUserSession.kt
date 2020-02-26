package com.marcin.wac.mvvmv2.utilities.persistence

interface IUserSession {
    fun logIn(accessToken: String)
    fun logOut()
    fun getToken(): String
}