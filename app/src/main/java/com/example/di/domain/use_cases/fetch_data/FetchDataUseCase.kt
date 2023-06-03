package com.example.di.domain.use_cases.fetch_data

import com.example.di.domain.model.Job
import com.example.di.domain.repository.JobRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchDataUseCase
@Inject
constructor(
    private val repository: JobRepository
) {
    suspend operator fun invoke(): List<Job>? {
        return withContext(Dispatchers.Default) { repository.getJobs() }
    }
}