package com.sicredi.sicrediteste.presenter.contract


interface ICheckInContract {
    interface ICheckInView{
        fun onSucess()
        fun onError(error:Throwable)
    }
    interface ICheckInPresenter{
        fun postCheckIn(url: String,eventId:String,name:String,email:String)
    }
}