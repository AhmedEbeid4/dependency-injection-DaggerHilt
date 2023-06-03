package com.example.di.data.repository

import android.util.Log
import com.example.di.data.api.JobApiService
import com.example.di.data.api.parseJobs
import com.example.di.data.database.JobsDatabase
import com.example.di.domain.model.Job
import com.example.di.domain.repository.JobRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JobRepositoryImp
    @Inject
    constructor
        (
        private val apiService: JobApiService,
        private val database: JobsDatabase
        )
    : JobRepository
    {
    override suspend fun getJobs(): List<Job>? {
        return try{
            val data: List<Job> = withContext(Dispatchers.IO) {
                parseJobs(apiService.getJobs())
            }
            database.jobsDao().updateData(data)
            Log.d("DATABASE",database.jobsDao().getAll().toString())
            data
        }catch (e:Exception){
            when(e.message.toString()){
                "Unable to resolve host \"www.arbeitnow.com\": No address associated with hostname" -> database.jobsDao().getAll()
                else -> null
            }
        }
    }
}