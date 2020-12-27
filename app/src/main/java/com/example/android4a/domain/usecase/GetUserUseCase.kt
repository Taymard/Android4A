package com.example.android4a.domain.usecase

import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.entity.User

class GetUserUseCase(private val userRepository: UserRepository) {

    suspend fun Invoke(email: String) : User?{
        return userRepository.getUser(email)
    }

}