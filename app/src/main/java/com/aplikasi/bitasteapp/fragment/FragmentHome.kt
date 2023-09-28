package com.aplikasi.bitasteapp.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplikasi.bitasteapp.adapter.ListAdapter
import com.aplikasi.bitasteapp.adapter.MainAdapter
import com.aplikasi.bitasteapp.data.DataDummy
import com.aplikasi.bitasteapp.databinding.FragmentHomeBinding


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