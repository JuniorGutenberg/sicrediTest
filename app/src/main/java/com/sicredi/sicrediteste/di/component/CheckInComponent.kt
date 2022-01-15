package com.sicredi.sicrediteste.di.component

import com.sicredi.sicrediteste.di.module.CheckInModule
import com.sicredi.sicrediteste.di.scope.ActivityScope
import com.sicredi.sicrediteste.view.activity.DetailsMainActivity
import dagger.Component

@ActivityScope
@Component(modules = [CheckInModule::class])
interface CheckInComponent {
    fun inject(detailsMain: DetailsMainActivity)
}