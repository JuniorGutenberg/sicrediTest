package com.sicredi.sicrediteste.services

import io.reactivex.Observable
import io.reactivex.internal.observers.EmptyCompletableObserver


interface CheckInService {
    fun addCheckIn(url:String,eventId:String, name:String, email:String):Observable<EmptyCompletableObserver>
}