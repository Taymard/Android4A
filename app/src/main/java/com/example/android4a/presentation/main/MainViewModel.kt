package com.example.android4a.presentation.main

import android.content.Context
import android.content.Intent
import android.widget.Toast
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
    val createLiveData: MutableLiveData<CreateAccountStatus> = MutableLiveData()

    fun onClickedLogin(mailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val user:User? = getUserUseCase.invoke(mailUser)
            var loginStatus: LoginStatus = LoginError
            if (user != null){
                if (user.password == password) {
                    loginStatus = LoginSucces(user.email)
                }
                else
                {
                    loginStatus = WrongPassword(user.email)
                }

            }else{
                loginStatus = LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onClickedCreate(mailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if(getUserUseCase.invoke(mailUser) == null)
            {
                createUserUseCase.invoke(user = User(mailUser,password))
            }
        }
    }

    fun userExist(email:String,password: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            var createAccountStatus: CreateAccountStatus
            if(email == "")
            {
                createAccountStatus = NoEntry
            }
            val user:User? = getUserUseCase.invoke(email)
            createAccountStatus = if (user == null){
                CreateSucces(email,password)
            }else{
                CreateError
            }
            withContext(Dispatchers.Main){
                createLiveData.value = createAccountStatus
            }
        }
    }

}
