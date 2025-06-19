
package com.example.userappcleanarchitecture.domain.usecase

import com.example.userappcleanarchitecture.domain.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {
    operator fun invoke() = repository.getUsers()
}
