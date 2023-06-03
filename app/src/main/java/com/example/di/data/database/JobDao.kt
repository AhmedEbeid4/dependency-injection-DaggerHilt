package com.example.di.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.di.domain.model.Job

@Dao
interface JobDao {

    @Query("SELECT * FROM cached_jobs")
    fun getAll(): List<Job>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(jobs: List<Job>): List<Long>

    @Query("DELETE FROM cached_jobs")
    fun deleteAll()

    @Transaction
    fun updateData(jobs: List<Job>): List<Long> {
        deleteAll()
        return insertAll(jobs)
    }

}