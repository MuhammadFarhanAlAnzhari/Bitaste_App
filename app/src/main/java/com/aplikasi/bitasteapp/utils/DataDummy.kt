package com.aplikasi.bitasteapp.utils

import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.data.Food

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
    private val location= arrayOf(
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
    private val description = arrayOf(
        "Ayam bakar adalah hidangan Indonesia yang populer, terutama di pulau Jawa. " +
                "Ini adalah hidangan ayam yang dimasak dengan cara dipanggang atau" +
                " dibakar setelah dibumbui dengan berbagai rempah-rempah dan " +
                "bumbu khas Indonesia. Proses pemanggangan atau pembakaran ini " +
                "biasanya dilakukan di atas bara api, arang, atau dalam oven.",
        "Ayam goreng adalah hidangan yang terdiri dari potongan-potongan ayam " +
                "yang dicelupkan dalam adonan atau bumbu tertentu, kemudian " +
                "digoreng hingga berwarna kecokelatan dan renyah. Hidangan ini " +
                "populer di seluruh dunia dan memiliki berbagai variasi sesuai " +
                "dengan budaya dan preferensi kuliner setempat.",
        "Cheese spaghetti adalah hidangan pasta yang menggunakan saus berbasis " +
                "keju sebagai bahan utama untuk memberikan rasa khas keju pada spageti. " +
                "Hidangan ini sangat populer di berbagai belahan dunia dan memiliki berbagai variasi resep.",
        "Sate ayam adalah hidangan Indonesia yang terkenal dan sangat populer. " +
                "Ini terdiri dari potongan-potongan daging ayam yang ditusuk dengan " +
                "tusukan bambu atau logam, kemudian dipanggang atau dibakar di " +
                "atas bara api atau gril. Hidangan ini biasanya disajikan " +
                "dengan saus kacang atau saus sate yang khas.",
        "Spicy Chicken Wings adalah hidangan yang terdiri dari sayap ayam " +
                "yang digoreng atau dipanggang dengan bumbu pedas. Hidangan ini " +
                "sangat populer di banyak negara, terutama di Amerika Serikat, dan " +
                "sering kali disajikan sebagai camilan atau hidangan " +
                "pembuka di restoran, bar, atau acara olahraga. ",
        "Sushi adalah hidangan tradisional Jepang yang terdiri dari seiris nasi " +
                "yang dibentuk bersama dengan bahan-bahan lain seperti ikan, " +
                "makanan laut, sayuran, telur, atau bahan-bahan lainnya. Hidangan " +
                "ini sering disajikan dalam potongan-potongan kecil dan seringkali " +
                "disajikan dengan saus, wasabi, dan jahe untuk memberikan rasa dan aroma yang khas.",
        "Burger adalah hidangan makanan yang terdiri dari potongan daging cincang atau " +
                "bahan pengganti daging yang biasanya disajikan dalam sepotong roti bundar " +
                "yang disebut bun. Hidangan ini sering disajikan dengan berbagai " +
                "tambahan seperti saus, sayuran, keju, dan bumbu-bumbu lainnya sesuai dengan selera individu.",
        "Chicken Garlic adalah hidangan yang mengandung ayam yang dimasak dengan " +
                "bawang putih sebagai bahan utama penyedap. Ini adalah hidangan " +
                "yang bervariasi dan dapat merujuk kepada berbagai jenis " +
                "hidangan ayam yang diolah dengan bawang putih.",
        "Dumplings adalah hidangan yang terdiri dari adonan yang biasanya dibentuk " +
                "menjadi potongan-potongan kecil dan diisi dengan berbagai bahan, " +
                "seperti daging, sayuran, atau campuran lainnya. Adonan biasanya terbuat " +
                "dari tepung terigu, air, dan garam, meskipun ada variasi dumplings yang " +
                "menggunakan adonan yang berbeda, seperti adonan pangsit atau adonan kentang.",
        "Frice Potato adalah hidangan yang terbuat dari potongan-potongan kentang " +
                "yang digoreng dalam minyak panas hingga menjadi renyah dan berwarna " +
                "kecokelatan. Ini adalah salah satu camilan yang sangat populer di seluruh " +
                "dunia dan seringkali disajikan sebagai makanan cepat saji atau hidangan pendamping di restoran.",
        "Pizza adalah hidangan makanan yang berasal dari Italia dan telah menjadi " +
                "salah satu hidangan paling terkenal dan dicintai di seluruh dunia. " +
                "Pizza terdiri dari adonan tipis yang biasanya dibentuk menjadi lingkaran " +
                "dan dilapisi dengan saus tomat, keju, dan berbagai bahan isian sesuai selera. " +
                "Hidangan ini kemudian dipanggang dalam oven hingga adonan matang dan kejunya meleleh."
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
                        rating[position],
                        location[position],
                        description[position]
                    )
                )
            }
            return list
        }

}