package com.example.questiongame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.questiongame.databinding.ItemRecyclerViewBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val mList = mutableListOf<String>()

    fun addItems(items:List<String>){
        mList.addAll(items)
    }

   inner class ViewHolder(private val binding: ItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items:String){
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int = mList.size

}