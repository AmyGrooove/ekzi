package com.example.ekzik.Main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ekzik.ChartList.ChartList
import com.example.ekzik.R
import com.example.ekzik.databinding.ActivityMainBinding

class Main : Activity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuObjects = arrayListOf(MenuJSON(R.drawable.elem1, "Обсуждения"), MenuJSON(R.drawable.elem3, "Подборки"), MenuJSON(R.drawable.elem2, "Избранное"))

        binding.recil.adapter = MenuAdapter(menuObjects){goToActivity(it)}
        binding.recil.layoutManager = GridLayoutManager(this@Main, 2)
    }

    fun goToActivity(title: String) {
        when (title) {
            "Обсуждения" -> {
                val intent = Intent(this, ChartList::class.java)
                startActivity(intent)
            }
            else -> {
                Log.d("Error", "nety")
            }
        }
    }
}