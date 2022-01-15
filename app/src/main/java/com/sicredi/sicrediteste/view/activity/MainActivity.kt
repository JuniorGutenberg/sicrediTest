package com.sicredi.sicrediteste.view.activity

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.sicredi.sicrediteste.R
import com.sicredi.sicrediteste.databinding.ActivityMainBinding
import com.sicredi.sicrediteste.di.component.DaggerEventsComponent
import com.sicredi.sicrediteste.di.module.EventsModule
import com.sicredi.sicrediteste.dto.EventsDTO
import com.sicredi.sicrediteste.presenter.EventsPresenter
import com.sicredi.sicrediteste.presenter.contract.IEventsContract
import com.sicredi.sicrediteste.utils.ViewUtils
import com.sicredi.sicrediteste.view.adapter.EventsAdapter
import com.sicredi.sicrediteste.view.enums.BaseUrl
import javax.inject.Inject

class MainActivity: Activity(),IEventsContract.IEventsView {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: EventsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerEventsComponent
            .builder()
            .eventsModule(EventsModule(this))
            .build()
            .inject(this)



        changeStatusBarColor()
        initializeComponents()
        callEvents()

    }
    private fun callEvents(){
        runOnUiThread {
            ViewUtils.loading(this)
            presenter.getEvents(BaseUrl.URL.value)
        }
    }
    private fun changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this,R.color.fundo)
        }
    }
    private fun initializeComponents(){
        binding.rvEvents.layoutManager = LinearLayoutManager(this)
    }

    override fun onSucess(response: List<EventsDTO>) {
        binding.rvEvents.adapter = EventsAdapter(response,this)
        runOnUiThread {
            ViewUtils.dismissLoading()
        }
    }

    override fun onError(error: Throwable) {
        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        runOnUiThread {
            ViewUtils.dismissLoading()
        }
    }
}