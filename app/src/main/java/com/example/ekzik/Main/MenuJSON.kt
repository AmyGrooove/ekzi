package com.example.ekzik.Main

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MenuJSON(
    @Json(name = "image")
    val image: Int,
    @Json(name = "title")
    val title: String,
)