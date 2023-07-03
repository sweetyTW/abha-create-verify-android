package com.example.abha_create_verify_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abha_create_verify_android.databinding.ActivityCreateAbhaBinding
import com.example.abha_sample.LaunchActivity
import com.example.abha_sample.SampleAbhaActivity

class CreateAbhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAbhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAbhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAbha)
        supportActionBar?.title = resources.getString(R.string.create_abha)


        binding.proceedButton.setOnClickListener {
            val intent = Intent(this, SampleAbhaActivity::class.java)
            startActivity(intent)
        }
    }
}