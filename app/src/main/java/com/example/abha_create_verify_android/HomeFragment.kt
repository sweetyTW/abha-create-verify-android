package com.example.abha_create_verify_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.abha_create_verify_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val includedTextViewLayoutBinding = binding.CreateABHAFragment
        includedTextViewLayoutBinding.buttonText.text = "Create ABHA"

        val includedLayoutBinding = binding.VerifyABHAFragment
        includedLayoutBinding.buttonText.text = "Verify ABHA"

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.CreateABHAFragment.buttonText.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_ValidationFragment)
        }

        binding.VerifyABHAFragment.buttonText.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_VerifyABHAFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


