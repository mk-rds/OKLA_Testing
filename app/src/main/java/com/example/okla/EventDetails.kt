package com.example.okla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class EventDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)
        val image: ImageView = findViewById(R.id.imageView)
        val Ename: TextView = findViewById(R.id.tvEname)
        val Edate: TextView = findViewById(R.id.tvEdate)
        val Eloc: TextView = findViewById(R.id.tvLoc)

        val bundle : Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val img =bundle.getInt("pic")
        val date = bundle.getString("date")
        val lokasi = bundle.getString("loc")

        Ename.text =name
        Edate.text = date
        Eloc.text = lokasi
        image.setImageResource(img)


    }
}