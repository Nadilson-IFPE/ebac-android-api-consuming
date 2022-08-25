package com.ebac.marvelheroes.presentation.view

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
                {
                    val texto2 = it.data.results[0].description
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(applicationContext, texto2, duration)
                    toast.show()
                },
                {}
            )
        }
    }
}