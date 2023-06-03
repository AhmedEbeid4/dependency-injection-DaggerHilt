package com.example.di.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.di.domain.model.Job

@Database(entities = [Job::class], version = 1)
abstract class JobsDatabase : RoomDatabase() {
    abstract fun jobsDao(): JobDao

    companion object {
        const val DATABASE_NAME = "job-db"
    }
}