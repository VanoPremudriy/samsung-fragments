package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.databinding.FragmentBlueBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class BlueFragment : Fragment() {

    private lateinit var _binding: FragmentBlueBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root

    }


}