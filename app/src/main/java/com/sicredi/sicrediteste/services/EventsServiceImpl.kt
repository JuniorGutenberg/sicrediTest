package com.sicredi.sicrediteste.services

import com.sicredi.sicrediteste.dto.EventsDTO
import com.sicredi.sicrediteste.model.EndPoint
import com.sicredi.sicrediteste.utils.NetworkUtils
import retrofit2.Call


class EventsServiceImpl : BaseService(), EventsService{

    override fun getEvents(url: String): Call<List<EventsDTO>> {
        val retrofit = NetworkUtils.getRetrofit(url)
        val endPoint = retrofit.create(EndPoint::class.java)
        return endPoint.getEvents()
   }

}