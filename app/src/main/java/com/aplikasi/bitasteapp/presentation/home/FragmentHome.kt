package com.aplikasi.bitasteapp.presentation.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.adapter.ListAdapter
import com.aplikasi.bitasteapp.adapter.MainAdapter

import com.aplikasi.bitasteapp.utils.DataDummy
import com.aplikasi.bitasteapp.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var listAdapter: ListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.visibility = View.VISIBLE

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_ic_home -> {
                    // Navigasi ke FragmentHome
                    findNavController().navigate(R.id.fragmentHome)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottom_ic_cart -> {
                    // Navigasi ke FragmentCart
                    findNavController().navigate(R.id.fragmentCart)
                    return@setOnNavigationItemSelectedListener true
                }R.id.bottom_ic_profile -> {
                    // Navigasi ke FragmentProfile
                    findNavController().navigate(R.id.fragmentProfile)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
        binding.ivSelectLanguage.setOnClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
        }

        binding.listSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                initRecyclerViewList()
                fetchListViewData()
            }else{
                initRecyclerView()
                fetchListData()
            }
        }
        initRecyclerView()
        fetchListData()
    }

    private fun fetchListData() {
        binding.rvMenu.adapter = MainAdapter(DataDummy.listData)
    }
    private fun fetchListViewData(){
        binding.rvMenu.adapter = ListAdapter(DataDummy.listData)
    }

    private fun initRecyclerView() {
        binding.rvMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvMenu.setHasFixedSize(true)
    }
    private fun initRecyclerViewList() {
        binding.rvMenu.layoutManager = LinearLayoutManager(requireContext(), )
        binding.rvMenu.setHasFixedSize(true)
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

}