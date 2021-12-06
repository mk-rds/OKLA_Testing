package com.example.okla.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.okla.R
import com.example.okla.models.event

class EventAdapter(
    private val eventList: List<event>, private val listener: OnItemClickListener,
) : RecyclerView.Adapter<EventAdapter.myViewHolder>()  {


    inner class myViewHolder(eventView: View) : RecyclerView.ViewHolder(eventView),
        View.OnClickListener {
        val eName: TextView = eventView.findViewById(R.id.tvEname)
        val eDate: TextView = eventView.findViewById(R.id.tvEdate)
        val ePic: ImageView = eventView.findViewById(R.id.imageView)

        init {//constructor
            eventView.setOnClickListener(this)


        }

        override fun onClick(v: View?) {
            val position:Int = absoluteAdapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val eventView = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_view, parent, false)

        return myViewHolder(eventView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentRec = eventList[position]
        holder.eName.text = currentRec.NAME
        holder.eDate.text = currentRec.Date
        holder.ePic.setImageResource(currentRec.Img)
    }

    override fun getItemCount(): Int {
        return eventList.size


    }


}