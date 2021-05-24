package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class LinksXXX(
    @SerializedName("self")
    val self: SelfXXX,
    @SerializedName("html")
    val html: HtmlXXX,
    @SerializedName("avatar")
    val avatar: AvatarXXX
)