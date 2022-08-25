package com.ebac.marvelheroes.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroiMarvelRepository {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object{
        val KEY = "YOUR_MARVEL_DEV_KEY_HERE"
        val TIMESTAMP = "YOUR_TIMESTAMP_HERE"
        val HASH = "YOUR_HASH_HERE"
    }
}