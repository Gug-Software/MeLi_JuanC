package com.jkgug.meli_juanc.data.remote.dto.error

data class ErrorResponseDto(
    val cause: List<Any?>,
    val error: String,
    val message: String,
    val status: Int
)