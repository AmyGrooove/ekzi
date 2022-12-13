package com.example.ekzik.ChartList

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ekzik.Main.MenuAdapter
import com.example.ekzik.Main.MenuJSON
import com.example.ekzik.R
import com.example.ekzik.databinding.ActivityChartListBinding
import com.example.ekzik.databinding.ActivityMainBinding

class ChartList : Activity() {
    private lateinit var binding: ActivityChartListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chartsStrings = arrayListOf("Lucifer", "The Witcher", "LOST", "The Magicans")

        binding.recilChart.adapter = ChartListAdapter(chartsStrings)
        binding.recilChart.layoutManager = LinearLayoutManager(this@ChartList)
    }
}