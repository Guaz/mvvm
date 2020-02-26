package com.marcin.wac.mvvmv2.data.models

import androidx.lifecycle.Observer

data class JokeResponse(val type: String, val value: Value)

data class Value(val id: Long, val joke: String, val categories: List<String>)