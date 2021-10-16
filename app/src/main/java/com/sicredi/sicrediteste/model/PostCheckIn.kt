package com.sicredi.sicrediteste.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PostCheckIn {
    @FormUrlEncoded
    @POST("checkin")
    fun postCheckIn(
        @Field("eventId") eventId:String,
        @Field("name") name:String,
        @Field("email") email:String
    ): Call<Response<Throwable>>
}