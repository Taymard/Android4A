package com.example.android4a.data.repository

import android.telephony.mbms.StreamingServiceInfo
import com.example.android4a.data.local.DatabaseDao
import com.example.android4a.data.local.models.UserLocal
import com.example.android4a.data.local.models.toData
import com.example.android4a.data.local.models.toEntity
import com.example.android4a.domain.entity.User
import com.example.android4a.injection.createDataBase
import com.example.android4a.injection.dataModule

class UserRepository(private val databaseDao: DatabaseDao) {
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())

    }
    fun getUser(email:String) : User? {
        val userLocal: UserLocal? = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }

}