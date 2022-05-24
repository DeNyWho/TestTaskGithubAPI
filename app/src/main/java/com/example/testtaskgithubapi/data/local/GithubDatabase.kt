package com.example.testtaskgithubapi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testtaskgithubapi.data.local.dao.UserDao
import com.example.testtaskgithubapi.domain.models.user.User
import com.example.testtaskgithubapi.util.Constants.GITHUB_DATABASE_DB

@Database(entities = [User::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class GithubDatabase: RoomDatabase() {

    companion object {
        fun create(context: Context, useInMemory: Boolean): GithubDatabase {

            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, GithubDatabase::class.java)
            } else {
                Room.databaseBuilder(context, GithubDatabase::class.java, GITHUB_DATABASE_DB)
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun userDao(): UserDao
}