package com.example.ekzik.Api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserPost(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String,
)