package com.sicredi.sicrediteste.di.module

import com.sicredi.sicrediteste.presenter.EventsPresenter
import com.sicredi.sicrediteste.presenter.contract.IEventsContract
import com.sicredi.sicrediteste.services.EventsService
import com.sicredi.sicrediteste.services.EventsServiceImpl
import dagger.Module
import dagger.Provides

@Module
class EventsModule (private val view: IEventsContract.IEventsView) {


    @Provides
    fun provideView(): IEventsContract.IEventsView {
        return view
    }

    @Provides
    fun providePresenter(
        eventsService: EventsService?,
        view: IEventsContract.IEventsView
    ): IEventsContract.IEventsPresenter? {
        return eventsService?.let { EventsPresenter(view,it) }
    }

    @Provides
    fun provideEventsService(): EventsService {
        return EventsServiceImpl()
    }
}