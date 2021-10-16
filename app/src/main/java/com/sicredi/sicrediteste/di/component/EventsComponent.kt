package com.sicredi.sicrediteste.di.component

import com.sicredi.sicrediteste.di.module.EventsModule
import com.sicredi.sicrediteste.di.scope.ActivityScope
import com.sicredi.sicrediteste.view.activity.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [EventsModule::class])
interface EventsComponent {
    fun inject(mainActivity: MainActivity)
}