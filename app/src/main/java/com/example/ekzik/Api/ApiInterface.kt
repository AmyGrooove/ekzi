package com.example.ekzik.Api

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

const val API_URL = ""

object ApiInterface {
    private val retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(MoshiConverterFactory.create()).build()
    val userApi: UserApi = retrofit.create(UserApi::class.java)
}

interface UserApi {
    @POST("user/login")
    suspend fun login(@Body user: UserPost): Response<Boolean>
}