package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Workspace(
    @SerializedName("slug")
    val slug: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("links")
    val links: LinksXX,
    @SerializedName("uuid")
    val uuid: String
)