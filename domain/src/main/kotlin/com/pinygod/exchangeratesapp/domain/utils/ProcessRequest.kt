package com.pinygod.exchangeratesapp.domain.utils

suspend fun <T> processRequest(block: suspend () -> T): Result<T> {
    return try {
        Result.success(block())
    } catch (e: Exception) {
        Result.failure(e)
    }
}