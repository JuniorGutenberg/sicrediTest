package com.sicredi.sicrediteste.model

import com.sicredi.sicrediteste.presenter.contract.IEventsContract
import org.jetbrains.annotations.Nullable


abstract class BasePresenter<VIEW : IEventsContract.IEventsView>(private var view: IEventsContract.IEventsView?) {


    @Nullable
    open fun getView(): VIEW? {
        return view as VIEW?
    }

 }