package com.example.android4a.presentation.main

import android.annotation.SuppressLint
import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock.sleep
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android4a.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.register_layout.*
import org.koin.android.ext.android.inject

class RegisterUser : AppCompatActivity(){

    val mainViewModel : MainViewModel by inject()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)

        Create_button.setOnClickListener{
            mainViewModel.onClickedCreate(login_create_edit.text.toString().trim(),password_create_edit.text.toString())
            val toast = Toast.makeText(this,"Account created", Toast.LENGTH_LONG)
            toast.show()
            sleep(2000)
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }

}