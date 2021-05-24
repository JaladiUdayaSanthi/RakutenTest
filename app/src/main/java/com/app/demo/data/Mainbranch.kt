package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Mainbranch(
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String
)