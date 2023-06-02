package com.example.di.data.api

import com.example.di.domain.model.Job
import org.json.JSONObject

fun parseJobs(input: String): List<Job> {

    val jobs = mutableListOf<Job>()
    val dataJsonArray = JSONObject(input).getJSONArray("data")
    for (i in 0 until dataJsonArray.length()) {

        val currJob = dataJsonArray.getJSONObject(i)

        val jobType = if (currJob.getJSONArray("job_types").length() != 0) {
            currJob.getJSONArray("job_types").getString(0)
        } else {
            "No Provided Job Type"
        }

        jobs.add(
            Job(
                currJob.getString("slug"),
                currJob.getString("title"),
                currJob.getString("company_name"),
                currJob.getBoolean("remote"),
                currJob.getString("url"),
                currJob.getString("location"),
                jobType
            )
        )
    }

    return jobs
}