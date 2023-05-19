package com.example.foodtracker.di

import android.content.SharedPreferences
import com.example.data.repositories.AddProductRepositoryImpl
import com.example.data.repositories.HomeRepositoryImpl
import com.example.data.repositories.NoteRepositoryImpl
import com.example.data.repositories.UserInfoRepositoryImpl
import com.example.domain.repositories.AddProductRepository
import com.example.domain.repositories.HomeRepository
import com.example.domain.repositories.NoteRepository
import com.example.domain.repositories.UserInfoRepository
import com.example.domain.usecases.DeleteNoteUseCase
import com.example.domain.usecases.SaveUserUseCase
import com.example.domain.usecases.GetHomeDataUseCase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
    fun provideRepository(sharedPreferences: SharedPreferences): UserInfoRepository =
        UserInfoRepositoryImpl(sharedPreferences)

    @Singleton
    @Provides
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore

    @Singleton
    @Provides
    fun provideHomeRepository(db: FirebaseFirestore): HomeRepository = HomeRepositoryImpl(db)

    @Singleton
    @Provides
    fun provideHomeUseCase(repository: HomeRepository): GetHomeDataUseCase =
        GetHomeDataUseCase(repository)

    @Singleton
    @Provides
    fun provideAddProductRepository(db: FirebaseFirestore): AddProductRepository =
        AddProductRepositoryImpl(db)

    @Singleton
    @Provides
    fun provideAddProductUseCase(addProductRepository: AddProductRepository): SaveUserUseCase =
        SaveUserUseCase(addProductRepository)

    @Singleton
    @Provides
    fun provideNoteRepository(db: FirebaseFirestore): NoteRepository =
        NoteRepositoryImpl(db)

    @Singleton
    @Provides
    fun provideDeleteNoteUseCase(repository: NoteRepository): DeleteNoteUseCase =
        DeleteNoteUseCase(repository)
}
