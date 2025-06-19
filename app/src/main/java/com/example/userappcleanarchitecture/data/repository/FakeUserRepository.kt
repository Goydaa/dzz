
package com.example.userappcleanarchitecture.data.repository

import com.example.userappcleanarchitecture.domain.model.User
import com.example.userappcleanarchitecture.domain.repository.UserRepository

class FakeUserRepository : UserRepository {
    private val users = mutableListOf<User>()
    private var idCounter = 1

    override suspend fun addUser(user: User) {
        users.add(user.copy(id = idCounter++))
    }

    override fun getUsers(): List<User> = users
}
