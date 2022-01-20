package com.sicredi.sicrediteste.presenter

import android.util.Log
import com.sicredi.sicrediteste.model.BasePresenterCheckIn
import com.sicredi.sicrediteste.presenter.contract.ICheckInContract
import com.sicredi.sicrediteste.services.CheckInService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.observers.EmptyCompletableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CheckInPresenter @Inject constructor(view:ICheckInContract.ICheckInView, private val checkInService: CheckInService):
    BasePresenterCheckIn<ICheckInContract.ICheckInView>(view), ICheckInContract.ICheckInPresenter {
    override fun postCheckIn(url: String, eventId: String, name: String, email: String) {

        checkInService.addCheckIn(url,eventId, name, email)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<EmptyCompletableObserver>{
                override fun onSubscribe(d: Disposable) {
                    Log.i("Subscribe","subscribe")
                }

                override fun onNext(t: EmptyCompletableObserver) {
                    Log.i("Next","next")
                }

                override fun onError(e: Throwable) {
                    getView()?.onError(e)
                }

                override fun onComplete() {
                    getView()?.onSucess()
                }

            })
    }
}