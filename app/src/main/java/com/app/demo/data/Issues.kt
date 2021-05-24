package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Issues(
    @SerializedName("href")
    val href: String
)