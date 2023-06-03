package com.example.di.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di.domain.model.Job
import com.example.di.domain.repository.JobRepository
import com.example.di.domain.use_cases.fetch_data.FetchDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class JobViewModel
@Inject
constructor(
    private val fetchUseCase: FetchDataUseCase
) : ViewModel() {
    private val _jobs = MutableLiveData<List<Job>?>()
    val jobs: LiveData<List<Job>?>
        get() = _jobs

    init {
        assignJobs()
    }

    private fun assignJobs() {
        viewModelScope.launch {
            _jobs.postValue(fetchUseCase())
        }
    }
}