package com.ebac.marvelheroes.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebac.marvelheroes.R
import com.ebac.marvelheroes.databinding.ActivityBuscaBinding
class BuscaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuscaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuscaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Titulo da toolbar
        setSupportActionBar(binding.toolbar).apply {
            title = getString(R.string.app_name)
        }
    }
}