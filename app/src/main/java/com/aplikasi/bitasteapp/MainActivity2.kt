package com.aplikasi.bitasteapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_main2)
        Handler().postDelayed({
            val intent = Intent(
                this@MainActivity2,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }, 3000)
    }
}
