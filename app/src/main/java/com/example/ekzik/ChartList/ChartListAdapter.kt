package com.example.ekzik.ChartList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ekzik.databinding.ChartListOneElementBinding

class ChartListAdapter (private val Chart: List<String>): RecyclerView.Adapter<ChartListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ChartListOneElementBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val chart = Chart[position]

        holder.binding.textView6.text = chart
    }

    override fun getItemCount(): Int {
        return Chart.size
    }

    class MyViewHolder(val binding: ChartListOneElementBinding) : RecyclerView.ViewHolder(binding.root)
}