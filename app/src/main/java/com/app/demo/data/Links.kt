package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("watchers")
    val watchers: Watchers,
    @SerializedName("branches")
    val branches: Branches,
    @SerializedName("tags")
    val tags: Tags,
    @SerializedName("commits")
    val commits: Commits,
    @SerializedName("clone")
    val clone: List<Clone>,
    @SerializedName("self")
    val self: Self,
    @SerializedName("source")
    val source: Source,
    @SerializedName("html")
    val html: Html,
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("hooks")
    val hooks: Hooks,
    @SerializedName("forks")
    val forks: Forks,
    @SerializedName("downloads")
    val downloads: Downloads,
    @SerializedName("pullrequests")
    val pullrequests: Pullrequests,
    @SerializedName("issues")
    val issues: Issues
)