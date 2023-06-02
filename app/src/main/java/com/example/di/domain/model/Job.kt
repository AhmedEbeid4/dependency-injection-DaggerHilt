package com.example.di.domain.model

data class Job(
    val id:String,
    val title: String,
    val companyName: String,
    val remote: Boolean,
    val url: String,
    val location: String,
    val jobType: String
) {

}