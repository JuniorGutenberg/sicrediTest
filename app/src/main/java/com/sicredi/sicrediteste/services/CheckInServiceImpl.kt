package com.sicredi.sicrediteste.services

import com.sicredi.sicrediteste.model.PostCheckIn
import com.sicredi.sicrediteste.utils.NetworkUtils
import io.reactivex.Observable
import io.reactivex.internal.observers.EmptyCompletableObserver

class CheckInServiceImpl: BaseService(), CheckInService {
    override fun addCheckIn(
        url: String,
        eventId: String,
        name: String,
        email: String
    ):Observable<EmptyCompletableObserver> {
        val retrofit = NetworkUtils.getRetrofit(url)
        val endPoint = retrofit.create(PostCheckIn::class.java)
        return endPoint.postCheckIn(eventId,name, email)
    }
}