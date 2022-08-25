package com.ebac.marvelheroes.data

import com.ebac.marvelheroes.data.model.HeroiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    @GET("v1/public/characters")
    fun buscarHeroiPorNome(
        @Query("name") name: String,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
    ): Call<HeroiResponse>

}