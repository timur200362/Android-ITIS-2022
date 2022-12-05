package com.example.android_itis_2022.Adapter

sealed interface Item{
    data class Game(
        val id:String,
        val name:String,
        val releaseDate:String,
        val descriptionGame:String,
        val cover:String
    ): Item
    data class Ad(
        val url:String
    ): Item
}

