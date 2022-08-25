package com.ebac.marvelheroes.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebac.marvelheroes.databinding.SeriesItemBinding

class SeriesAdapter(private val listaSeries: ArrayList<String>) :
    RecyclerView.Adapter<SeriesAdapter.SerieItemViewHolder>() {
    class SerieItemViewHolder(private val binding: SeriesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(nomeSerie: String) {
            binding.tituloSerie.text = nomeSerie
        }

    }

    override fun onCreateViewHolder(parentView: ViewGroup, viewType: Int): SerieItemViewHolder {
        val binding = SeriesItemBinding.inflate(LayoutInflater.from(parentView.context), parentView, false)
        return SerieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SerieItemViewHolder, position: Int) {
        val nomeSerie = listaSeries[position]
        holder.bind(nomeSerie)
    }

    override fun getItemCount(): Int {
        return listaSeries.size
    }
}