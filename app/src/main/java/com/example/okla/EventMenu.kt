package com.example.okla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.okla.adapter.EventAdapter
import com.example.okla.models.event
import java.util.*

class EventMenu : AppCompatActivity(), EventAdapter.OnItemClickListener {


    private var eventList = mutableListOf<event>(
        event("Workshop", "13 December 2021 ", "My home", R.drawable.p1),
        event("Blood Donation", "21 December 2021", "Library", R.drawable.p2),
        event("Bonding", "15 December 2021", "Center", R.drawable.p1),
        event("Just nice", "10 December 2021", "Hiking", R.drawable.p2),
        event("Bonding", "15 December 2021", "Center", R.drawable.p1),
        event("Just nice", "10 December 2021", "Hiking", R.drawable.p2)
    )
    private var tempList = eventList


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_item, menu)
//
//        val item = menu?.findItem(R.id.search_action)
//        val searchView = item?.actionView as SearchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//
//                tempList.clear()
//                val searchedText = newText!!.lowercase(Locale.getDefault())
//
//                if (searchedText.isNotEmpty()) {
//                    tempList.forEach{
//                        if(it.NAME.lowercase(Locale.getDefault()).contains(searchedText)){
//                                tempList.add(it)
//                        }
//                    }
//                    myRV.adapter?.notifyDataSetChanged()
//
//                } else {
//                    tempList.clear()
//                    tempList.addAll(eventList)
//                    myRV.adapter?.notifyDataSetChanged()
//
//                }
//
//                return false
//            }
//        })
//
//        return super.onCreateOptionsMenu(menu)
//    }


    override fun onItemClick(position: Int) {
//        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, EventDetails::class.java)
        intent.putExtra("pic", eventList[position].Img)
        intent.putExtra("name", eventList[position].NAME)
        intent.putExtra("date", eventList[position].Date)
        intent.putExtra("loc", eventList[position].Loc)

        startActivity(intent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eventAdapter = EventAdapter(tempList, this)


         val myRV: RecyclerView = findViewById(R.id.MyRecycleView)
        myRV.adapter = eventAdapter
        myRV.layoutManager = LinearLayoutManager(this)
        myRV.setHasFixedSize(true)

    }
}