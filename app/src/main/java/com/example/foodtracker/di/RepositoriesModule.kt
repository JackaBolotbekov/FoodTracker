package com.example.foodtracker.di

import com.example.data.repositories.DefaultKcalRepositoryImpl
import com.example.data.repositories.SingleShowLogInRepositoryImpl
import com.example.data.repositories.SingleShowOnBoardRepositoryImpl
import com.example.domain.repositories.DefaultKcalRepository
import com.example.domain.repositories.SingleShowLogInRepository
import com.example.domain.repositories.SingleShowOnBoardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun singleShowLogInRepository(singleShowLogInRepositoryImpl: SingleShowLogInRepositoryImpl): SingleShowLogInRepository

    @Binds
    abstract fun singleShowOnBoardRepository(singleShowOnBoardRepositoryImpl: SingleShowOnBoardRepositoryImpl): SingleShowOnBoardRepository

    @Binds
    abstract fun saveDefaultKcalRepository(defaultKcalRepositoryImpl: DefaultKcalRepositoryImpl): DefaultKcalRepository
}