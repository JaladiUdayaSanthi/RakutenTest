package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Downloads(
    @SerializedName("href")
    val href: String
)