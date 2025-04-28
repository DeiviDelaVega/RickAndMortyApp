package com.rickapp.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickapp.databinding.LayoutDesingCardBinding
import com.rickapp.model.Character

class Adapter(private val listCharacter: ArrayList<Character>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemBinding = LayoutDesingCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(listCharacter[position])

    }

    override fun getItemCount(): Int  = listCharacter.size

    class MyViewHolder(val binding: LayoutDesingCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.shapeableImageView2.setImageResource(character.imagenResId)
            binding.leftText.text = character.nombre
        }
    }
}