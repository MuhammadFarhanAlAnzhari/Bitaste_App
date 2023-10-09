package com.aplikasi.bitasteapp.presentation.cart

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.adapter.CartAdapter
import com.aplikasi.bitasteapp.data.SetViewModel
import com.aplikasi.bitasteapp.data.room.FoodDatabase
import com.aplikasi.bitasteapp.data.room.RoomEntity
import com.aplikasi.bitasteapp.databinding.FragmentCartBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FragmentCart : Fragment() {

    lateinit var binding: FragmentCartBinding
    lateinit var cartViewModel: SetViewModel
    lateinit var cartAdapter: CartAdapter
    var dbFood: FoodDatabase? = null

    // Variabel untuk melacak total harga
    var totalHarga = 0

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

        GlobalScope.launch {
            cartViewModel.getAllData()
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
                R.id.bottom_ic_cart -> {
                    // Navigasi ke FragmentCart
                    findNavController().navigate(R.id.fragmentCart)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

        cartAdapter.plusCount = { item ->
            GlobalScope.launch {
                val hargaAwal = item.harga.replace("[^0-9]".toRegex(), "").toInt() / item.stock
                val totalHargaSementara = item.harga.replace("[^0-9]".toRegex(), "").toInt()
                val hargaBaru = hargaAwal * (item.stock + 1)
                totalHarga += hargaBaru - totalHargaSementara // Tambah selisih harga baru dan harga sementara
                cartViewModel.updateCount(item.stock + 1, item.id, hargaBaru)
                cartViewModel.getAllData()

                activity?.runOnUiThread {
                    val tvTotalPrice = view.findViewById<TextView>(R.id.tv_total_price) // Ganti dengan ID TextView yang sesuai
                    tvTotalPrice.text = "Rp. $totalHarga"
                }
            }
        }

        cartAdapter.minCount = { item ->
            GlobalScope.launch {
                val hargaAwal = item.harga.replace("[^0-9]".toRegex(), "").toInt() / item.stock
                val totalHargaSementara = item.harga.replace("[^0-9]".toRegex(), "").toInt()
                if (item.stock > 1) {
                    val hargaBaru = hargaAwal * (item.stock - 1)
                    totalHarga += hargaBaru - totalHargaSementara
                    cartViewModel.updateCount(item.stock - 1, item.id, hargaBaru)
                    cartViewModel.getAllData()

                    activity?.runOnUiThread {
                        val tvTotalPrice = view.findViewById<TextView>(R.id.tv_total_price)
                        tvTotalPrice.text = "Rp. $totalHarga"
                    }
                }
            }
        }
        binding.btnOrder.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCart_to_confirmFragment)
            Handler().postDelayed({
                findNavController().navigate(R.id.fragmentHome)
            }, 1000)
        }
    }


    fun setVM() {
        cartAdapter = CartAdapter(ArrayList())
        binding.rvMenuCart.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvMenuCart.adapter = cartAdapter
    }

    override fun onStart() {
        super.onStart()
    }
}
