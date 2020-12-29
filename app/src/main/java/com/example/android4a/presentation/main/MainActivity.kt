package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it)
            {
                is LoginSucces ->{
                    val intent: Intent = Intent(this,MenuActivity::class.java)
                    startActivity(intent)
                }
                LoginError -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Erreur")
                    .setMessage("Compte Inconnu")
                    .setPositiveButton("Ok"){
                        dialog, which -> dialog.dismiss()
                    }.show()
                }
            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(),password_edit.text.toString())
        }

        create_account_button.setOnClickListener{
            val intent = Intent(this, RegisterUser::class.java)
            startActivity(intent)
        }


    }
}