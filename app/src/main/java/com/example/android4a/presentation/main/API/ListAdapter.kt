package com.example.android4a.presentation.main.API

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android4a.R
import com.example.android4a.domain.entity.Pokemon
import kotlinx.android.synthetic.main.row_layout.view.*

class ListAdapter(
    private val PokemonList: MutableList<Pokemon>,
    private val context: Context
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.icon
        val header:TextView = itemView.firstLine
        val footer:TextView = itemView.secondLine

    }

    fun add(position: Int,item:Pokemon){
        PokemonList.add(item)
        notifyItemInserted(position)
    }

    fun remove(position: Int)
    {
        PokemonList.removeAt(position)
        notifyItemRemoved(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount() = PokemonList.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val pokemon:Pokemon = PokemonList[position]
        holder.header.text = pokemon.name
        holder.header.setOnClickListener{
            val intent = Intent(context, PokeStatActivity::class.java)
            intent.putExtra("name", pokemon.name)
            intent.putExtra("type", pokemon.type)
            intent.putExtra("weaknesses", pokemon.weaknesses)
            intent.putExtra("height", pokemon.height)
            intent.putExtra("weight", pokemon.weight)
            intent.putExtra("prev", pokemon.prev_evolution)
            intent.putExtra("next", pokemon.next_evolution)
            intent.putExtra("img", pokemon.img)
            context.startActivity(intent)
        }

        holder.footer.text = pokemon.num
        Glide.with(context).load(pokemon.img).into(holder.imageView)
        holder.imageView.setOnClickListener{
            val intent = Intent(context, PokeStatActivity::class.java)
            intent.putExtra("name", pokemon.name)
            intent.putExtra("type", pokemon.type)
            intent.putExtra("weaknesses", pokemon.weaknesses)
            intent.putExtra("height", pokemon.height)
            intent.putExtra("weight", pokemon.weight)
            intent.putExtra("prev", pokemon.prev_evolution)
            intent.putExtra("next", pokemon.next_evolution)
            intent.putExtra("img", pokemon.img)
            context.startActivity(intent)
        }
    }
}