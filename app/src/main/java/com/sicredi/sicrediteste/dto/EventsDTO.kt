package com.sicredi.sicrediteste.dto

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
class EventsDTO (

    @SerializedName("id") var id:String?,
    @SerializedName("title") var title: String?,
    @SerializedName("price") var price: Double?,
    @SerializedName("latitude") var latitude: Double?,
    @SerializedName("longitude") var longitude: Double?,
    @SerializedName("image") var image: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("date") var date: Long?,



    ):Parcelable
