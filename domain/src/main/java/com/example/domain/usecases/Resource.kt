package com.example.domain.usecases

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : Resource<T>()
    data class Success<T>(val result: T) : Resource<T>(result)
    data class Error<T>(val throwable: String) : Resource<T>()
}
