package com.example.abha_create_verify_android

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.abha_create_verify_android.databinding.FragmentOtpBinding
import java.net.HttpURLConnection
import java.net.URL


class OTPFragment : Fragment() {

    private var _binding: FragmentOtpBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOtpBinding.inflate(inflater, container, false)

        val includedTextViewLayoutBinding = binding.includedTextViewLayout
        includedTextViewLayoutBinding.headerText.text = "Check your Aadhaar linked mobile number"
        includedTextViewLayoutBinding.textInput.hint ="Enter OTP"

        binding.resentOTP.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.resentOTP.checkBox.text = if (isChecked) "OTP Verified" else "Send OTP again?"
        }

        val includedLayoutBinding = binding.includedButtonLayout
        includedLayoutBinding.buttonText.text = "Proceed"

        return binding.root

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.includedButtonLayout.buttonText.setOnClickListener {
            val arg = binding.includedTextViewLayout.textInput.text.toString();

//            val action = ValidationFragmentDirections.actionCreateABHAFragmentToCreateABHANextFragment(arg)
//            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}