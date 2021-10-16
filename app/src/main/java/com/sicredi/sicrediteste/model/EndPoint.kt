package com.sicredi.sicrediteste.model

import com.sicredi.sicrediteste.dto.EventsDTO
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    @GET("events")
    fun getEvents(): Call<List<EventsDTO>>

}