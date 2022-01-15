package com.sicredi.sicrediteste.view.adapter.viewholder

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sicredi.sicrediteste.databinding.ItemCardsEventsBinding
import com.sicredi.sicrediteste.dto.EventsDTO
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

import com.bumptech.glide.load.resource.bitmap.CenterCrop

import com.bumptech.glide.request.RequestOptions
import com.sicredi.sicrediteste.R
import com.sicredi.sicrediteste.view.activity.DetailsMainActivity


class EventsViewHolder(private val binding: ItemCardsEventsBinding, var context: Context):
    RecyclerView.ViewHolder(binding.root){

    fun bind(eventsDTO: EventsDTO){
        binding.tv.text = eventsDTO.title


        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

        Glide.
            with(context)
            .load(eventsDTO.image)
            .apply(requestOptions)
            .error(R.drawable.img_not_found)
            .into(binding.iv)

        itemView.setOnClickListener {
            val intent = Intent(context, DetailsMainActivity::class.java)
            intent.putExtra("image", eventsDTO.image)
            intent.putExtra("price", eventsDTO.price)
            intent.putExtra("desc", eventsDTO.description)
            intent.putExtra("date", eventsDTO.date)
            intent.putExtra("title", eventsDTO.title)
            intent.putExtra("eventId", eventsDTO.id)

            context.startActivity(intent)
        }
    }
}