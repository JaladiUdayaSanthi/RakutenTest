package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Clone(
    @SerializedName("href")
    val href: String,
    @SerializedName("name")
    val name: String
)