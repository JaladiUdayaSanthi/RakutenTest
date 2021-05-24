package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Project(
    @SerializedName("links")
    val links: LinksX,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("uuid")
    val uuid: String
)