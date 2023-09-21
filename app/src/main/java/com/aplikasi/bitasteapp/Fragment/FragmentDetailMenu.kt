package com.aplikasi.bitasteapp.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.aplikasi.bitasteapp.Data.Food
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.databinding.FragmentDetailMenuBinding
import com.aplikasi.bitasteapp.databinding.FragmentHomeBinding
import com.bumptech.glide.Glide


class FragmentDetailMenu : Fragment() {

    lateinit var binding: FragmentDetailMenuBinding

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
            Navigation.findNavController(it).navigate(R.id.action_fragmentDetailMenu2_to_fragmentHome)
        }
        binding.cvLocation.setOnClickListener {
            val data = binding.dataLocation.text.toString()
            val uri = Uri.parse("https://www.google.com/maps/search/$data")
            val mapIntent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(mapIntent)
        }
    }

}