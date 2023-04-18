package com.example.foodtracker.di

import android.content.SharedPreferences
import com.example.data.repositories.UserInfoRepositoryImpl
import com.example.domain.repositories.UserInfoRepository
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
    fun provideRepository(sharedPreferences: SharedPreferences): UserInfoRepository {
        return UserInfoRepositoryImpl(sharedPreferences)
    }
}