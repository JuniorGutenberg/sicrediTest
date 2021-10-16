package com.sicredi.sicrediteste.model

import com.sicredi.sicrediteste.presenter.contract.ICheckInContract
import org.jetbrains.annotations.Nullable

abstract class BasePresenterCheckIn<VIEW: ICheckInContract.ICheckInView>(private val view:ICheckInContract.ICheckInView) {
    @Nullable
    open fun getView(): VIEW? {
        return view as VIEW?
    }
}