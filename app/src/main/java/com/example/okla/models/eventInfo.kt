package com.example.okla.models

data class eventInfo(

    var eName: String,
    var hName: String,
    var eDate: String,
    var Location: String,
    var Longitude: String,
    var Latitude: String,
    var eCategory: String

)

data class event(
    var NAME:String,
    var Date : String,
    var Loc : String,
    var Img : Int
)
