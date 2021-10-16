package com.sicredi.sicrediteste.services

import retrofit2.Call
import retrofit2.Response

interface CheckInService {
    fun addCheckIn(url:String,eventId:String, name:String, email:String): Call<Response<Throwable>>
}