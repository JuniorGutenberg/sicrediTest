package com.sicredi.sicrediteste.di.module

import com.sicredi.sicrediteste.presenter.CheckInPresenter
import com.sicredi.sicrediteste.presenter.contract.ICheckInContract
import com.sicredi.sicrediteste.services.CheckInService
import com.sicredi.sicrediteste.services.CheckInServiceImpl
import dagger.Module
import dagger.Provides

@Module
class CheckInModule (private val view: ICheckInContract.ICheckInView) {

    @Provides
    fun provideView():ICheckInContract.ICheckInView{
        return view
    }

    @Provides
    fun providePresenter(
        checkInService: CheckInService,
        view: ICheckInContract.ICheckInView
    ):ICheckInContract.ICheckInPresenter{
        return CheckInPresenter(view,checkInService)
    }

    @Provides
    fun provideCheckInService():CheckInService{
        return CheckInServiceImpl()
    }
}