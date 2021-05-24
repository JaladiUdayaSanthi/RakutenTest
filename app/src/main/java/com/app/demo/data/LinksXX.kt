package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class LinksXX(
    @SerializedName("self")
    val self: SelfXX,
    @SerializedName("html")
    val html: HtmlXX,
    @SerializedName("avatar")
    val avatar: AvatarXX
)