package com.example.di.data.api

import retrofit2.http.GET

object ApiConstants {
    const val BASE_URL = "https://www.arbeitnow.com/api/"
}

interface JobApiService{
    @GET("job-board-api")
    suspend fun getJobs():String
}

