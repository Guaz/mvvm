package com.marcin.wac.mvvmv2.data.models

data class JokeResponse(val type: String, val value: List<Value>)

data class Value(val id: Long, val joke: String, val categories: List<String>)