package com.example.di.data.repository

import android.util.Log
import com.example.di.data.api.JobApiService
import com.example.di.data.api.parseJobs
import com.example.di.domain.model.Job
import com.example.di.domain.repository.JobRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JobRepositoryImp
    @Inject
    constructor
        (private val apiService: JobApiService)
    : JobRepository
    {
    override var jobs: List<Job> = mutableListOf()
    override suspend fun getJobs(): List<Job> {
        val data: List<Job> = withContext(Dispatchers.IO) {
            parseJobs(apiService.getJobs())
        }
        jobs = data
        Log.d("DATA",data.toString())
        Log.d("DATA",jobs.toString())
        return data
    }
}