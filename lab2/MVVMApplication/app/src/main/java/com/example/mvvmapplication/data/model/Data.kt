package com.example.mvvmapplication.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
) : Parcelable