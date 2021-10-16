package com.sicredi.sicrediteste.services

import com.sicredi.sicrediteste.model.PostCheckIn
import com.sicredi.sicrediteste.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Response

class CheckInServiceImpl: BaseService(), CheckInService {
    override fun addCheckIn(
        url: String,
        eventId: String,
        name: String,
        email: String
    ): Call<Response<Throwable>> {
        val retrofit = NetworkUtils.getRetrofit(url)
        val endPoint = retrofit.create(PostCheckIn::class.java)
        return endPoint.postCheckIn(eventId,name, email)
    }
}