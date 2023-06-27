package com.example.abha_create_verify_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.abha_create_verify_android.databinding.ActivityAadhaarOtpactivityBinding
import com.example.abha_create_verify_android.databinding.ActivityAbhaOtpactivityBinding

class AbhaOTPActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAbhaOtpactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbhaOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAbha)
        supportActionBar?.title = resources.getString(R.string.create_abha)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.proceedButton.setOnClickListener {
            val intent = Intent(this, PatientBioActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Handle back button click here
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}