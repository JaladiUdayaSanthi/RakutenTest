package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("self")
    val self: SelfX,
    @SerializedName("html")
    val html: HtmlX,
    @SerializedName("avatar")
    val avatar: AvatarX
)