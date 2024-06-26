package com.alijan.demo.data.model


import com.google.gson.annotations.SerializedName

data class Pray(
    @SerializedName("saat")
    val saat: String?,
    @SerializedName("vakit")
    val vakit: String?
)