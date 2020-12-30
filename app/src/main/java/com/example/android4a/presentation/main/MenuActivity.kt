package com.example.android4a.presentation.main

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android4a.R
import kotlinx.android.synthetic.main.menu_layout.*
import org.koin.android.ext.android.inject

class MenuActivity : AppCompatActivity() {
    val mainViewModel : MainViewModel by inject()

    private var mediaPlayer: MediaPlayer? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_layout)

        button.setOnClickListener(){
            val toast: Toast = Toast.makeText(this,"Wesh ca marche",Toast.LENGTH_LONG)
            toast.show()
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.pokemon_fireredleafgreen_route_11)
        if (!mediaPlayer!!.isPlaying) {
            mediaPlayer!!.start()
            mediaPlayer!!.isLooping = true
        }

    }
}