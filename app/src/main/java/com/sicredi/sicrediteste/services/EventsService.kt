package com.sicredi.sicrediteste.services

import com.sicredi.sicrediteste.dto.EventsDTO
import io.reactivex.Observable

interface EventsService {

    fun getEvents(url:String): Observable<List<EventsDTO>>

}