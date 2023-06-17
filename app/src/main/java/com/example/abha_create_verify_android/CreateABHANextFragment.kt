package com.example.abha_create_verify_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.abha_create_verify_android.databinding.FragmentCreateAbhaBinding
import com.example.abha_create_verify_android.databinding.FragmentCreateAbhaNextBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CreateABHANextFragment : Fragment() {
    private lateinit var arg: String

    private var _binding: FragmentCreateAbhaNextBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateAbhaNextBinding.inflate(inflater, container, false)

        val includedLayoutBinding = binding.includedBackButtonLayout
        includedLayoutBinding.buttonText.text = "Back"

        arguments?.let {
            arg = it.getString("arg") ?: ""
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.headerText)
        textView.text = "you have entererd: $arg"

        binding.includedBackButtonLayout.buttonText.setOnClickListener {
            findNavController().navigate(R.id.action_CreateABHANextFragment_to_CreateABHAFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}