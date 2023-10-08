package com.aplikasi.bitasteapp.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.databinding.FragmentProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.visibility = View.VISIBLE

        binding.ivBackProfile.setOnClickListener {
            findNavController().navigateUp()
        }


    }

}
