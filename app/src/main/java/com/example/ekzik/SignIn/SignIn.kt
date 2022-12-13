package com.example.ekzik.SignIn

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns.EMAIL_ADDRESS
import com.example.ekzik.Api.ApiInterface
import com.example.ekzik.Api.UserPost
import com.example.ekzik.Main.Main
import com.example.ekzik.databinding.ActivityMainBinding
import com.example.ekzik.databinding.ActivitySignInBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class SignIn : Activity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (isValid(binding.editTextTextEmailAddress.text.toString()) && isValidEmail(binding.editTextTextEmailAddress2.text.toString())) {
                val user = UserPost(binding.editTextTextEmailAddress.text.toString(), binding.editTextTextEmailAddress2.text.toString())
                var flag = false

                try {
                    CoroutineScope(Dispatchers.Main).launch {
                        val result = ApiInterface.userApi.login(user)
                        if (result.isSuccessful) {
                            flag = true
                        }
                    }
                } catch (e: Exception) {
                    Log.d("Error", e.toString())
                }

                if (flag) {
                    startActivity(Intent(this, Main::class.java))
                    finish()
                }
            }
        }
    }

    private fun isValid(value: String): Boolean {
        return value.length > 4
    }

    private fun isValidEmail(value: String): Boolean {
        return EMAIL_ADDRESS.matcher(value).matches()
    }
}