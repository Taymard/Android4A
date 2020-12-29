package com.example.android4a.presentation.main

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase:CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(mailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //getUserUseCase.Invoke(mailUser)
            //createUserUseCase.invoke(User("test"))
            val user:User? = getUserUseCase.invoke(mailUser)
            val loginStatus: LoginStatus = if (user != null){
                LoginSucces(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onClickedCreate(mailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(user = User(mailUser,password))

        }
    }
}
