package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("links")
    val links: LinksXXX,
    @SerializedName("type")
    val type: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("account_id")
    val accountId: Any?,
    @SerializedName("username")
    val username: String
)