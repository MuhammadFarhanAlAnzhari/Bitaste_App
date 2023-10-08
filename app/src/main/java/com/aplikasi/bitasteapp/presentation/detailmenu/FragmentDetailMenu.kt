package com.aplikasi.bitasteapp.presentation.detailmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.data.SetViewModel
import com.aplikasi.bitasteapp.data.room.RoomEntity
import com.aplikasi.bitasteapp.databinding.FragmentDetailMenuBinding
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class FragmentDetailMenu : Fragment() {

    lateinit var binding: FragmentDetailMenuBinding
    lateinit var detailMenuViewModel: SetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailMenuViewModel = ViewModelProvider(this).get(SetViewModel::class.java)


        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.visibility = View.GONE
        val bundle = arguments
        val menu = bundle!!.getString("namaMenu")
        val price = bundle!!.getString("hargaMenu")
        val rating = bundle!!.getDouble("rating")
        val image = bundle!!.getInt("gambar")
        val location = bundle!!.getString("loc")
        val description = bundle!!.getString("description")


        binding.tvPriceDetail.text = price
        binding.tvFoodNameDetail.text = menu
        binding.tvRatingDetail.text = rating.toString()
        binding.dataLocation.text = location.toString()
        binding.tvDescription.text = description
        Glide.with(requireContext()).load(image).into(binding.ivRectangleImg)
        Glide.with(requireContext()).load(image).into(binding.banner)
        binding.ivBack.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmentDetailMenu2_to_fragmentHome)
        }
        binding.cvLocation.setOnClickListener {
            val data = binding.dataLocation.text.toString()
            val uri = Uri.parse("https://www.google.com/maps/search/$data")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(mapIntent)
        }
        binding.btnAddCart.setOnClickListener {
            val stock = binding.tvNumber.text.toString()
                detailMenuViewModel.insertData(
                    RoomEntity(
                        0,
                        menu!!,
                        image,(price!!.replace("[^0-9]".toRegex(), "").toInt()*binding.tvNumber.text.toString().toInt()).toString()
                        ,
                        stock.toString().toInt()
                    )
                )
                findNavController().navigate(R.id.action_fragmentDetailMenu2_to_fragmentCart)
        }

        countingFood()
    }

     fun countingFood() {
        var foodTotal = 0
        binding.cvPlusButton.setOnClickListener {
            foodTotal += 1
            binding.tvNumber.text = foodTotal.toString()
        }
        binding.cvMinusButton.setOnClickListener {
            if (foodTotal > 0) {
                foodTotal -= 1
                binding.tvNumber.text = foodTotal.toString()
            }
        }
    }



}


