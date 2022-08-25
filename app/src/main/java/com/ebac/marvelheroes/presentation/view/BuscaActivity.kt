package com.ebac.marvelheroes.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ebac.marvelheroes.R
import com.ebac.marvelheroes.data.HeroiMarvelRepository
import com.ebac.marvelheroes.databinding.ActivityBuscaBinding

class BuscaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuscaBinding
    val repository = HeroiMarvelRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuscaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Titulo da toolbar
        setSupportActionBar(binding.toolbar).apply {
            title = getString(R.string.app_name)
        }

        binding.botaoPesquisar.setOnClickListener {
            val text = binding.barraPesquisa.text.toString()

            repository.buscarHeroiPorNome(text,
                { heroi ->
                    val intent = Intent(this, InformacoesHeroi::class.java)
                    val b = Bundle()

                    b.putString("nome", heroi.data.results[0].name)
                    b.putString("descricao", heroi.data.results[0].description)

                    intent.putExtras(b)
                    startActivity(intent)
                },
                {}
            )
        }
    }
}