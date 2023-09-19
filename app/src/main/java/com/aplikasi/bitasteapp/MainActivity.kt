package com.aplikasi.bitasteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.recyclerview.widget.GridLayoutManager
import com.aplikasi.bitasteapp.databinding.ActivityMainBinding
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val bahasa = findViewById<ShapeableImageView>(R.id.iv_select_language)
//        bahasa.setOnClickListener{
//            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
//        }
//        fetchListData()
//        initRecyclerView()
//    }
//    private fun fetchListData(){
//        binding.rvMenu.adapter=MainAdapter(DataDummy.listData)
//    }
//    private fun initRecyclerView(){
//        binding.rvMenu.layoutManager=GridLayoutManager(this, 2)
//        binding.rvMenu.setHasFixedSize(true)
    }
}