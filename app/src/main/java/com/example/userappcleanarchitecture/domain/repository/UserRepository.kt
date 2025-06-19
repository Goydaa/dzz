
package com.example.userappcleanarchitecture.domain.repository

import com.example.userappcleanarchitecture.domain.model.User

interface UserRepository {
    suspend fun addUser(user: User)
    fun getUsers(): List<User>
}
