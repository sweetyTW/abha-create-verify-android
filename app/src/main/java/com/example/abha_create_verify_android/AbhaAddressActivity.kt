package com.example.abha_create_verify_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abha_create_verify_android.databinding.ActivityAbhaAddressBinding
import com.example.abha_create_verify_android.databinding.ActivityCreateAbhaBinding

class AbhaAddressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAbhaAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abha_address)
        binding = ActivityAbhaAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAbha)
        supportActionBar?.title = resources.getString(R.string.create_abha)
    }

}