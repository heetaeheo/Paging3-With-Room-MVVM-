package com.example.paging3withroom

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3withroom.databinding.RecyclerListBinding
import com.example.paging3withroom.db.CharacterData

class RecyclerAdapter : PagingDataAdapter<CharacterData, RecyclerAdapter.MyViewHodler>(DiffUtilCallback()) {


    class MyViewHodler(private val binding : RecyclerListBinding) : RecyclerView.ViewHolder(binding.root){
        val textViewName = binding.title


        fun bind(characterData: CharacterData){
            textViewName.text = characterData.name
        }
    }

    override fun onBindViewHolder(holder: MyViewHodler, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodler {
        val binding = RecyclerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHodler(binding)
    }

    class  DiffUtilCallback: DiffUtil.ItemCallback<CharacterData>() {
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.name == newItem.name
        }
    }
}