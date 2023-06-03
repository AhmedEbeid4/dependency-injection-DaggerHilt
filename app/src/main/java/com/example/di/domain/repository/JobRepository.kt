package com.example.di.domain.repository

import com.example.di.domain.model.Job

interface JobRepository {
    suspend fun getJobs():List<Job>?
}