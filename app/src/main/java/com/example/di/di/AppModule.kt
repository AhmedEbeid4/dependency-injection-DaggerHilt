package com.example.di.di

import android.content.Context
import androidx.room.Room
import com.example.di.data.api.ApiConstants
import com.example.di.data.api.JobApiService
import com.example.di.data.database.JobDao
import com.example.di.data.database.JobsDatabase
import com.example.di.data.repository.JobRepositoryImp
import com.example.di.domain.repository.JobRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJobApiService() : JobApiService {
        return Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .baseUrl(ApiConstants.BASE_URL)
            .build()
            .create(JobApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideJobsRepository(
        api: JobApiService,
        jobsDb: JobsDatabase
    ): JobRepository {
        return JobRepositoryImp(api,jobsDb)
    }

    @Provides
    @Singleton
    fun providesJobsDB(@ApplicationContext context: Context): JobsDatabase {
        return Room.databaseBuilder(
            context,
            JobsDatabase::class.java,
            JobsDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideJobsDAO(jobsDb: JobsDatabase): JobDao {
        return jobsDb.jobsDao()
    }

}