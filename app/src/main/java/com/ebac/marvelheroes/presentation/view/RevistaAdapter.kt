package com.ebac.marvelheroes.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebac.marvelheroes.databinding.RevistaItemBinding

class RevistaAdapter(private val listaRevistas: ArrayList<String>) :
    RecyclerView.Adapter<RevistaAdapter.RevistaItemViewHolder>() {
    class RevistaItemViewHolder(private val binding: RevistaItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(nomeRevista: String) {
            binding.tituloRevista.text = nomeRevista
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevistaItemViewHolder {
        val binding = RevistaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RevistaItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RevistaItemViewHolder, position: Int) {
        val nomeRevista = listaRevistas[position]
        holder.bind(nomeRevista)
    }

    override fun getItemCount(): Int {
        return listaRevistas.size
    }
}