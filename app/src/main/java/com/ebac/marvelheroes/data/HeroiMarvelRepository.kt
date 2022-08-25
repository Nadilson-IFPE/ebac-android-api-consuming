package com.ebac.marvelheroes.data

import com.ebac.marvelheroes.data.model.HeroiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroiMarvelRepository {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun buscarHeroiPorNome(nome: String, sucesso: (HeroiResponse) -> Unit, erro: () -> Unit){
        val api = retrofit.create(MarvelAPI::class.java)

        api.buscarHeroiPorNome(nome, KEY, TIMESTAMP, HASH).enqueue(
            object: Callback<HeroiResponse> {
                override fun onResponse(call: Call<HeroiResponse>?, response: Response<HeroiResponse>?) {
                    if (response?.isSuccessful == true) {
                        sucesso(response.body())
                    } else {
                        erro()
                    }
                }

                override fun onFailure(call: Call<HeroiResponse>?, t: Throwable?) {
                    erro()
                }

            }
        )
    }

    companion object{
        val KEY = "YOUR_MARVEL_DEV_KEY_HERE"
        val TIMESTAMP = "YOUR_TIMESTAMP_HERE"
        val HASH = "YOUR_HASH_HERE"
    }
}