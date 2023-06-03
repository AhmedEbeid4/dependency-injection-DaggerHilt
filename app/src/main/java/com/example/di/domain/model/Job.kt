package com.example.di.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached_jobs")
data class Job(
    @PrimaryKey
    val id:String,
    val title: String,
    val companyName: String,
    val remote: Boolean,
    val url: String,
    val location: String,
    val jobType: String
) {

}