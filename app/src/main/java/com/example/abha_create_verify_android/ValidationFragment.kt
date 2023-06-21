package com.example.abha_create_verify_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.abha_create_verify_android.databinding.FragmentValidationBinding
import okhttp3.OkHttpClient
import okhttp3.Request


class ValidationFragment : Fragment() {

    private var _binding: FragmentValidationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentValidationBinding.inflate(inflater, container, false)

        val includedTextViewLayoutBinding = binding.includedTextViewLayout
        includedTextViewLayoutBinding.headerText.text = "Aadhaar Validation"
        includedTextViewLayoutBinding.textInput.hint ="Enter your Aadhaar number"

        val includedLayoutBinding = binding.includedButtonLayout
        includedLayoutBinding.buttonText.text = "Proceed"

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.includedButtonLayout.buttonText.setOnClickListener {
            val arg = binding.includedTextViewLayout.textInput.text.toString();

            val action = ValidationFragmentDirections.actionValidationFragmentToOTPFragment(arg)
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}