package com.example.ekzik.Main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ekzik.databinding.MenuOneElementBinding

class MenuAdapter (private val Menu: List<MenuJSON>, val click: (String) -> Unit) : RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MenuOneElementBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val menu = Menu[position]

        holder.binding.imageView2.setImageResource(menu.image)
        holder.binding.textView3.text = menu.title

        holder.binding.root.setOnClickListener {
            click(menu.title)
        }
    }

    override fun getItemCount(): Int {
        return Menu.size
    }

    class MyViewHolder(val binding: MenuOneElementBinding) : RecyclerView.ViewHolder(binding.root)
}