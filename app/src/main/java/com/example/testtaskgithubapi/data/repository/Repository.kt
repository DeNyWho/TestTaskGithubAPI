package com.example.testtaskgithubapi.data.repository

import com.example.testtaskgithubapi.core.SafeCall
import com.example.testtaskgithubapi.core.error.GeneralError
import com.example.testtaskgithubapi.core.wrapper.Resource
import com.example.testtaskgithubapi.data.remote.api.UserService
import com.example.testtaskgithubapi.data.remote.models.dto.ContentSearchResponse
import com.example.testtaskgithubapi.di.AndroidKtorClient
import com.example.testtaskgithubapi.util.Constants.HOST
import com.example.testtaskgithubapi.util.Constants.SEARCH
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    @AndroidKtorClient private val client: HttpClient,
    private val safeCall: SafeCall

): UserService {
    override suspend fun searchUser(query: String, page: Int): Resource<ContentSearchResponse> {
        val request = HttpRequestBuilder().apply {
            method = HttpMethod.Get
            url {
                protocol = URLProtocol.HTTPS
                host = HOST
                encodedPath = SEARCH
                parameter("q", query)
                parameter("page", page)
            }
        }

        return safeCall<ContentSearchResponse, GeneralError>(client, request)

    }

}