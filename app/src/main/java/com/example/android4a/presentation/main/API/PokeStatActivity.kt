package com.example.android4a.presentation.main.API

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.android4a.R
import kotlinx.android.synthetic.main.poke_stats_layout.*

class PokeStatActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poke_stats_layout)

        val intent = intent
        val name = intent.getStringExtra("name")
        val type = intent.getStringExtra("type")
        val weakness = intent.getStringExtra("weaknesses")
        val height = intent.getStringExtra("height")
        val weigth = intent.getStringExtra("weight")
        val prev = intent.getStringExtra("prev")
        val next = intent.getStringExtra("next")
        val img = intent.getStringExtra("img")

        val Name = findViewById<View>(R.id.textView1) as TextView
        val Type = findViewById<View>(R.id.textView2) as TextView
        val Weakness = findViewById<View>(R.id.textView3) as TextView
        val Height = findViewById<View>(R.id.textView4) as TextView
        val Weigth = findViewById<View>(R.id.textView5) as TextView
        val Prev = findViewById<View>(R.id.textView6) as TextView
        val Next = findViewById<View>(R.id.textView7) as TextView
        val imageView =
            findViewById<View>(R.id.imageView) as ImageView

        Name.text = "Name : $name"
        Type.text = "Type : $type"
        Weakness.text = "Weak to : $weakness"
        Height.text = "Height : $height"
        Weigth.text = "Weight : $weigth"
        Prev.text = "Previous Evolution : $prev"
        Next.text = "Next Evolution : $next"
        Glide.with(this).load(img).into(imageView)

        Model.setOnClickListener{
            Toast.makeText(this, "Not currently available", Toast.LENGTH_SHORT).show()
        }

    }
}