package com.app.demo.data


import com.google.gson.annotations.SerializedName

data class ResponseList(
    @SerializedName("pagelen")
    val pagelen: Int,
    @SerializedName("values")
    val values: List<Value>,
    @SerializedName("next")
    val next: String
)

data class Value(
        @SerializedName("scm")
        val scm: String,
        @SerializedName("website")
        val website: String,
        @SerializedName("has_wiki")
        val hasWiki: Boolean,
        @SerializedName("uuid")
        val uuid: String,
        @SerializedName("links")
        val links: Links,
        @SerializedName("fork_policy")
        val forkPolicy: String,
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("project")
        val project: Project,
        @SerializedName("language")
        val language: String,
        @SerializedName("created_on")
        val createdOn: String,
        @SerializedName("mainbranch")
        val mainbranch: Mainbranch,
        @SerializedName("workspace")
        val workspace: Workspace,
        @SerializedName("has_issues")
        val hasIssues: Boolean,
        @SerializedName("owner")
        val owner: Owner,
        @SerializedName("updated_on")
        val updatedOn: String,
        @SerializedName("size")
        val size: Int,
        @SerializedName("type")
        val type: String,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("is_private")
        val isPrivate: Boolean,
        @SerializedName("description")
        val description: String
)

