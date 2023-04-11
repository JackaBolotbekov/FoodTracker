package com.example.foodtracker.di

import android.content.SharedPreferences
import com.example.data.repository.SharedRepositoryImpl
import com.example.domain.repository.SharedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRepository(sharedPreferences: SharedPreferences) : SharedRepository {
        return SharedRepositoryImpl(sharedPreferences)
    }
}