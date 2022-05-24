package com.example.testtaskgithubapi.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AndroidKtorClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OkHttpKtorClient