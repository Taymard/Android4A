package com.example.android4a.presentation.main

sealed class CreateAccountStatus

data class CreateSucces(val email:String,val password: String) : CreateAccountStatus()

object CreateError : CreateAccountStatus()
object NoEntry : CreateAccountStatus()
