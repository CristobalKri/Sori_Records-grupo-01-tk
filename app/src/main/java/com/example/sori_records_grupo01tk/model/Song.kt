package com.example.sori_records_grupo01tk.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class BillboardResponse(
    @SerializedName("info") val info: Info?,
    @SerializedName("content") val content: JsonObject?
)

data class Info(
    @SerializedName("category") val category: String?,
    @SerializedName("chart") val chart: String?,
    @SerializedName("date") val date: String?,
    @SerializedName("source") val source: String?
)

data class Song(
    @SerializedName("rank") val rank: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("artist") val artist: String?,
    @SerializedName("weeks at no.1") val weeksAtNo1: String? = null,
    @SerializedName("last week") val lastWeek: String? = null,
    @SerializedName("peak position") val peakPosition: String? = null,
    @SerializedName("weeks on chart") val weeksOnChart: String? = null,
    @SerializedName("detail") val detail: String? = null
)
