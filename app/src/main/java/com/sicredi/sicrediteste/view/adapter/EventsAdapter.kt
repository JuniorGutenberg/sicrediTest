package com.sicredi.sicrediteste.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sicredi.sicrediteste.databinding.ItemCardsEventsBinding
import com.sicredi.sicrediteste.dto.EventsDTO
import com.sicredi.sicrediteste.view.adapter.viewholder.EventsViewHolder

class EventsAdapter(var list: List<EventsDTO>, var context: Context):
    RecyclerView.Adapter<EventsViewHolder>() {

    lateinit var binding:ItemCardsEventsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        binding = ItemCardsEventsBinding.inflate(LayoutInflater.from(context),parent,false)
        return EventsViewHolder(binding,context)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }
}