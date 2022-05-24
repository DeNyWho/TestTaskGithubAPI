package com.example.testtaskgithubapi.data.remote.models.dto

import com.example.testtaskgithubapi.domain.models.ContentSearch
import com.example.testtaskgithubapi.domain.models.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("login")
    val login: String = "",
    @SerialName("id")
    val id: Int = 0,
    @SerialName("node_id")
    val nodeId: String = "",
    @SerialName("avatar_url")
    val avatarUrl: String = "",
    @SerialName("gravatar_id")
    val GravatarId: String = "",
    @SerialName("url")
    val url: String = "",
    @SerialName("html_url")
    val htmlUrl: String = "",
    @SerialName("followers_url")
    val FollowersUrl: String = "",
    @SerialName("following_url")
    val FollowingUrl: String = "",
    @SerialName("gists_url")
    val GistsUrl: String = "",
    @SerialName("starred_url")
    val StarredUrl: String = "",
    @SerialName("subscriptions_url")
    val SubscriptionsUrl: String = "",
    @SerialName("organizations_url")
    val OrganizationsUrl:String = "",
    @SerialName("repos_url")
    val ReposUrl: String = "",
    @SerialName("events_url")
    val EventsUrl: String ="",
    @SerialName("received_events_url")
    val ReceivedEventsUrl: String = "",
    @SerialName("type")
    val type: String = "",
    @SerialName("site_admin")
    val siteAdmin: Boolean = false,
    @SerialName("score")
    val score: Double = 1.0
)


fun UserDto.toUser(): ContentSearch {
    return ContentSearch(
        login = login,
        id = id,
        avatarURL = avatarUrl,
        type = type
    )
}
















