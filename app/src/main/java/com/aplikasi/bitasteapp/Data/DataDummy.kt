package com.aplikasi.bitasteapp.Data

import com.aplikasi.bitasteapp.R

object DataDummy {
    private val image= arrayOf(
        R.drawable.img_ayam_bakar,
        R.drawable.img_ayam_goreng,
        R.drawable.img_cheese_spaghetti,
        R.drawable.img_sate_ayam,
        R.drawable.img_spicy_chicken_wings,
        R.drawable.img_sushi,
        R.drawable.img_burger,
        R.drawable.img_chicken_garlic,
        R.drawable.img_dumplings,
        R.drawable.img_frice_potato,
        R.drawable.img_pizza
    )
    private val name= arrayOf(
        "Ayam Bakar",
        "Ayam Goreng",
        "Cheese Spaghetti",
        "Sate Ayam",
        "Spicy Chicken Wings",
        "Sushi",
        "Burger",
        "Chicken Garlic",
        "Dumplings",
        "Frice Potato",
        "Pizza"
    )

    private val price= arrayOf(
        "Rp. 10.000",
        "Rp. 20.000",
        "Rp. 30.000",
        "Rp. 40.000",
        "Rp. 50.000",
        "Rp. 60.000",
        "Rp. 70.000",
        "Rp. 80.000",
        "Rp. 90.000",
        "Rp. 20.000",
        "Rp. 50.000"
    )

    private val rating= arrayOf(
        4.8,
        4.5,
        4.7,
        4.4,
        4.6,
        4.9,
        4.3,
        4.7,
        4.9,
        4.5,
        4.6
    )
    val listData: ArrayList<Food>
        get() {
            val list= arrayListOf<Food>()
            for (position in name.indices){
                list.add(
                    Food(
                        image[position],
                        name[position],
                        price[position],
                        rating[position]
                    )
                )
            }
            return list
        }

}