package com.bgyhnddr.nestedscrolldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val group = findViewById<ViewGroup>(R.id.groupContent)

        for (i in 0..100) {
            val text = TextView(this)
            text.text = "group${i}"
            group.addView(text)
        }

        val goods = findViewById<ViewGroup>(R.id.goodsContent)
        for (i in 0..200) {
            val text = TextView(this)
            text.text = "goods${i}"
            goods.addView(text)
        }

        findViewById<ViewGroup>(R.id.main).scrollBy(0, 700)
    }
}