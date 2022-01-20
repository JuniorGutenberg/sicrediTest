package com.sicredi.sicrediteste.services

import com.sicredi.sicrediteste.dto.EventsDTO
import com.sicredi.sicrediteste.model.EndPoint
import com.sicredi.sicrediteste.utils.NetworkUtils
import io.reactivex.Observable


class EventsServiceImpl : BaseService(), EventsService{

    override fun getEvents(url: String): Observable<List<EventsDTO>> {
        val retrofit = NetworkUtils.getRetrofit(url)
        val endPoint = retrofit.create(EndPoint::class.java)
        return endPoint.getEvents()
   }

}