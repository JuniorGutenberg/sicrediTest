package com.sicredi.sicrediteste.presenter

import com.sicredi.sicrediteste.dto.EventsDTO
import com.sicredi.sicrediteste.model.BasePresenter
import com.sicredi.sicrediteste.presenter.contract.IEventsContract
import com.sicredi.sicrediteste.services.EventsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class EventsPresenter @Inject constructor(view: IEventsContract.IEventsView,private val eventsService: EventsService):
    BasePresenter<IEventsContract.IEventsView>(view),IEventsContract.IEventsPresenter {

    override fun getEvents(url: String) {
        eventsService.getEvents(url).enqueue(object :  Callback<List<EventsDTO>>{
            override fun onResponse(
                call: Call<List<EventsDTO>>,
                response: Response<List<EventsDTO>>
            ) {
                response.body()?.let {
                    getView()?.onSucess(it)
                }
            }

            override fun onFailure(call: Call<List<EventsDTO>>, t: Throwable) {
                getView()?.onError(t)
            }
        })
    }
}