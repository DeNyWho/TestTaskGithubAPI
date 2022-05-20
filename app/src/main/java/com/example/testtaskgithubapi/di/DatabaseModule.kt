package com.example.testtaskgithubapi.di

import android.content.Context
import androidx.room.Room
import com.example.testtaskgithubapi.data.local.GithubDatabase
import com.example.testtaskgithubapi.util.Constants.GITHUB_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): GithubDatabase {
        return Room.databaseBuilder(
            context,
            GithubDatabase::class.java,
            GITHUB_DATABASE
        ).build()
    }


    @Provides
    @Singleton
    fun provideUserDao(
        githubDatabase: GithubDatabase
    ) = githubDatabase.userDao()

}