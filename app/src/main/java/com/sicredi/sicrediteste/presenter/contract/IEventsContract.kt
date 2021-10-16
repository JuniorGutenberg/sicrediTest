package com.sicredi.sicrediteste.presenter.contract

import com.sicredi.sicrediteste.dto.EventsDTO

interface IEventsContract {

    interface IEventsView{
        fun onSucess(response: List<EventsDTO>)
        fun onError(error:Throwable)
    }
    interface IEventsPresenter{
        fun getEvents(url: String)
    }
}