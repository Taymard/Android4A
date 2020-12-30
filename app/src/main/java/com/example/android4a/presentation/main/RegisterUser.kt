package com.example.android4a.presentation.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.register_layout.*
import org.koin.android.ext.android.inject
import java.util.Observer

class RegisterUser : AppCompatActivity(){

    val mainViewModel : MainViewModel by inject()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)


        mainViewModel.createLiveData.observe(this, androidx.lifecycle.Observer {
            when(it)
            {
                is CreateSucces -> {
                    mainViewModel.onClickedCreate(login_create_edit.text.toString().trim(),password_create_edit.text.toString())
                    val toast:Toast = Toast.makeText(this,"Account created",Toast.LENGTH_LONG)
                    toast.show()
                    val intent: Intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                CreateError -> {
                    var toast:Toast = Toast.makeText(this,"this User already exist",Toast.LENGTH_LONG)
                    toast.show()
                }
                NoEntry -> {
                    var toast:Toast = Toast.makeText(this,"please type a username",Toast.LENGTH_LONG)
                    toast.show()
                }
            }
        })

        Create_button.setOnClickListener{
            mainViewModel.userExist(login_create_edit.text.toString().trim(),password_create_edit.text.toString())
        }

    }

}