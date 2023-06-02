package com.example.di.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.di.R
import com.example.di.adapters.JobAdapter
import com.example.di.databinding.ActivityMainBinding
import com.example.di.presentation.viewmodel.JobViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: JobViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.jobsRecyclerView.adapter = JobAdapter { goToCompanyWebsite(it) }
        viewModel = ViewModelProvider(this)[JobViewModel::class.java]
        viewModel.jobs.observe(this) { binding.viewModel = viewModel }
    }

    private fun goToCompanyWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}