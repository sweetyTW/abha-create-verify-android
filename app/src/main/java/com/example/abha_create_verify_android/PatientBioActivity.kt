package com.example.abha_create_verify_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.abha_create_verify_android.data.api.ApiHelper
import com.example.abha_create_verify_android.data.api.RetrofitBuilder
import com.example.abha_create_verify_android.data.model.VerifyAadhaarOTPResp
import com.example.abha_create_verify_android.databinding.ActivityPatientBioBinding
import com.example.abha_create_verify_android.utils.Status

class PatientBioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatientBioBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val patient = intent.getSerializableExtra("patient") as? VerifyAadhaarOTPResp;
        binding = ActivityPatientBioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()

        setSupportActionBar(binding.toolbarAbha)
        supportActionBar?.title = resources.getString(R.string.create_abha)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        binding.patientName.text = patient?.fullName.toString()
        binding.dateOfBirth.text = patient?.birthdate.toString()
        binding.gender.text = patient?.gender.toString()
        binding.phoneNumber.text = intent.getStringExtra("mobile").toString()
        val address = StringBuilder()
        listOfNotNull(
            patient?.house,
            patient?.street,
            patient?.villageTownCity,
            patient?.district,
            patient?.state,
            patient?.pincode
        ).forEach { str ->
            if (address.isNotEmpty()) {
                address.append(", ")
            }
            address.append(str)
        }
        binding.address.text =  address.toString()
        binding.proceedButton.setOnClickListener {
            viewModel.createHealthIdByAdhaarOtp().observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            resource.data?.let { data ->
                                val intent = Intent(this, AbhaAddressActivity::class.java)
                                intent.putExtra("healthId", data.healthIdNumber)
                                startActivity(intent)
                            }
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility= View.GONE
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                    }
                }
            })
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
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