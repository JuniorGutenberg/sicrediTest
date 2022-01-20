package com.sicredi.sicrediteste.model

import com.sicredi.sicrediteste.dto.EventsDTO
import io.reactivex.Observable
import retrofit2.http.GET

interface EndPoint {

    @GET("events")
    fun getEvents(): Observable<List<EventsDTO>>

}