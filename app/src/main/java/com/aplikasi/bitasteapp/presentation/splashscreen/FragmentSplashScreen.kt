package com.aplikasi.bitasteapp.presentation.splashscreen

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.databinding.FragmentSplashScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class FragmentSplashScreen : Fragment() {

    lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.visibility = View.GONE
        Handler().postDelayed({
            findNavController().navigate(R.id.action_fragmentSplashScreen_to_fragmentHome)
        },2000)

    }


}