package com.sicredi.sicrediteste.services

import com.sicredi.sicrediteste.dto.EventsDTO
import retrofit2.Call

interface EventsService {

    fun getEvents(url:String):Call<List<EventsDTO>>

}