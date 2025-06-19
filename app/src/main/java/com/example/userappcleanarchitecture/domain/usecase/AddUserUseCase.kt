
package com.example.userappcleanarchitecture.domain.usecase

import com.example.userappcleanarchitecture.domain.model.User
import com.example.userappcleanarchitecture.domain.repository.UserRepository

class AddUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) = repository.addUser(user)
}
