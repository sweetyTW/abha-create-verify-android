package com.example.abha_create_verify_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.abha_create_verify_android.data.api.ApiHelper
import com.example.abha_create_verify_android.data.api.RetrofitBuilder
import com.example.abha_create_verify_android.data.model.GenerateAadhaarOTPReq
import com.example.abha_create_verify_android.databinding.ActivityCreateAbhaBinding
import com.example.abha_create_verify_android.utils.Status

class CreateAbhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAbhaBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAbhaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()

        setSupportActionBar(binding.toolbarAbha)
        supportActionBar?.title = resources.getString(R.string.create_abha)

        binding.proceedButton.setOnClickListener {
            viewModel.generateAadhaarOtp(GenerateAadhaarOTPReq(binding.aadhaarEditText.text.toString())).observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            resource.data?.let { users -> binding.apiResponseTextView.text =
                               "mobileNumber is" + users.mobileNumber
                            }
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility= View.GONE
                            resource.data?.let { error -> binding.apiResponseTextView.text =
                                "error is" + error.toString()
                            }
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

}