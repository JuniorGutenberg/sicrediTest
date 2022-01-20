package com.sicredi.sicrediteste.presenter

import android.util.Log
import com.sicredi.sicrediteste.dto.EventsDTO
import com.sicredi.sicrediteste.model.BasePresenter
import com.sicredi.sicrediteste.presenter.contract.IEventsContract
import com.sicredi.sicrediteste.services.EventsService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class EventsPresenter @Inject constructor(view: IEventsContract.IEventsView,private val eventsService: EventsService):
    BasePresenter<IEventsContract.IEventsView>(view),IEventsContract.IEventsPresenter {

    override fun getEvents(url: String) {
        eventsService.getEvents(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<EventsDTO>>{
                override fun onComplete() {
                    Log.e("Complete","showComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e("Inscrito","su")
                }

                override fun onError(e: Throwable) {
                    getView()?.onError(e)
                }

                override fun onNext(t: List<EventsDTO>) {
                    getView()?.onSucess(t)
                }
            })
    }
}