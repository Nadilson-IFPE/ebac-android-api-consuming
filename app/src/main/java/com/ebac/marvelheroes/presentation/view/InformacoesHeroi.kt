package com.ebac.marvelheroes.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebac.marvelheroes.databinding.ActivityInformacoesHeroiBinding
import com.ebac.marvelheroes.presentation.view.adapter.RevistaAdapter
import com.ebac.marvelheroes.presentation.view.adapter.SeriesAdapter

class InformacoesHeroi : AppCompatActivity() {

    private lateinit var binding: ActivityInformacoesHeroiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacoesHeroiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras

        val nome = b?.getString("nome") ?: ""
        val desc = b?.getString("descricao") ?: ""

        binding.nomeHeroi.text = nome
        binding.resumoHeroi.text = desc

        val adapterComics = RevistaAdapter(
            arrayListOf("Revista #1", "Revista #2", "Revista #3")
        )

        val adapterSeries = SeriesAdapter(
            arrayListOf("Série #1", "Série #2", "Série #3")
        )

        val layoutManagerComics = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listaQuadrinhos.layoutManager = layoutManagerComics
        binding.listaQuadrinhos.adapter = adapterComics

        val layoutManagerSeries = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listaSeries.layoutManager = layoutManagerSeries
        binding.listaSeries.adapter = adapterSeries
    }
}