package com.example.ejemplohilos

class Movie (private val name: String,
             val duration: Int){
    fun play():String{
        var message = ""
        for (i in 0 .. duration)
            message += "Playing movie: $name \n"
        return message
    }
}