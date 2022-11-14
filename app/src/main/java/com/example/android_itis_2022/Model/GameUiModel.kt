package com.example.android_itis_2022.Model

sealed interface MainItem{
    data class GameUiModel(
        val id:String,
        val name:String,
        val releaseDate:String,
        val descriptionGame:String,
        val cover:String
    ):MainItem
}