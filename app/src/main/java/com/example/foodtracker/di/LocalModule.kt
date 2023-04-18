package com.example.foodtracker.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideSingleDisplay(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(com.example.presentation.R.string.key_shared),
            Context.MODE_PRIVATE
        )
    }
}