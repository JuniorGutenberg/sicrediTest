package com.sicredi.sicrediteste.presenter

import com.sicredi.sicrediteste.model.BasePresenterCheckIn
import com.sicredi.sicrediteste.presenter.contract.ICheckInContract
import com.sicredi.sicrediteste.services.CheckInService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CheckInPresenter @Inject constructor(view:ICheckInContract.ICheckInView, private val checkInService: CheckInService):
    BasePresenterCheckIn<ICheckInContract.ICheckInView>(view), ICheckInContract.ICheckInPresenter {
    override fun postCheckIn(url: String, eventId: String, name: String, email: String) {
        checkInService.addCheckIn(url,eventId, name, email).enqueue(object :
            Callback<Response<Throwable>>{
            override fun onResponse(
                call: Call<Response<Throwable>>,
                response: Response<Response<Throwable>>
            ) {
                getView()?.onSucess()
            }

            override fun onFailure(call: Call<Response<Throwable>>, t: Throwable) {
                getView()?.onError(t)
            }
        })
    }
}