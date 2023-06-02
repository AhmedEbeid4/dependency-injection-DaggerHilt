package com.example.di.domain.repository

import com.example.di.domain.model.Job

interface JobRepository {
    var jobs:List<Job>
    suspend fun getJobs():List<Job>
}