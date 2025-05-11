package com.example.EcoShop.repository

import com.example.EcoShop.data.UserDao

import com.example.EcoShop.model.User

class UserRepository(private val userDao: UserDao) {
  suspend fun registerUser(user: User) {
    userDao.registerUser(user)
  }

  suspend fun loginUser(email: String, password: String): User? {
    return userDao.loginUser(email, password)
  }
}
