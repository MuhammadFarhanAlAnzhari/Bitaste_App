package com.aplikasi.bitasteapp.presentation.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.adapter.CartAdapter
import com.aplikasi.bitasteapp.data.SetViewModel
import com.aplikasi.bitasteapp.data.room.FoodDatabase
import com.aplikasi.bitasteapp.data.room.RoomEntity
import com.aplikasi.bitasteapp.databinding.FragmentCartBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


@Suppress("DEPRECATION")
class FragmentCart : Fragment() {

    lateinit var binding: FragmentCartBinding
    lateinit var cartViewModel: SetViewModel
    lateinit var cartAdapter: CartAdapter
    var dbFood: FoodDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBackCart.setOnClickListener {
            findNavController().navigateUp()
        }
        cartViewModel = ViewModelProvider(this).get(SetViewModel::class.java)
        setVM()
        cartViewModel.getFoodObserver().observe(viewLifecycleOwner) {
            cartAdapter.setData(it as ArrayList<RoomEntity>)
        }


        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_ic_home -> {
                    // Navigasi ke FragmentHome
                    findNavController().navigate(R.id.fragmentHome)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottom_ic_profile -> {
                // Navigasi ke FragmentProfile
                findNavController().navigate(R.id.fragmentProfile)
                return@setOnNavigationItemSelectedListener true
                }

                else -> false
            }

        }

    }



    fun setVM(){
        cartAdapter = CartAdapter(ArrayList())
        binding.rvMenuCart.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvMenuCart.adapter = cartAdapter
    }
    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            cartViewModel.getAllData()
        }
    }
}