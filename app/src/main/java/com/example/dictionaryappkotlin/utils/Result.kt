package com.example.dictionaryappkotlin.utils

/**
 * AUTHOR Syed Ahmed Kamal, CREATED ON (6/18/2024).
 */
sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?): Result<T>(data)
    class Loading<T>(val isLoading: Boolean = true): Result<T>(null)
    class Error<T>(message: String): Result<T>(null, message)
}