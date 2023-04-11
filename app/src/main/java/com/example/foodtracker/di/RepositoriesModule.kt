package com.example.foodtracker.di

import com.example.data.repository.SharedRepositoryImpl
import com.example.domain.repository.SharedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindSharedRepository(repositoryImpl: SharedRepositoryImpl): SharedRepository

}