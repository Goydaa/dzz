
package com.example.userappcleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userappcleanarchitecture.data.repository.FakeUserRepository
import com.example.userappcleanarchitecture.domain.model.User
import com.example.userappcleanarchitecture.domain.usecase.AddUserUseCase
import com.example.userappcleanarchitecture.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = FakeUserRepository()
    private val addUserUseCase = AddUserUseCase(repository)
    private val getUsersUseCase = GetUsersUseCase(repository)

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        loadUsers()
    }

    fun addUser(name: String, age: Int) {
        viewModelScope.launch {
            addUserUseCase(User(0, name, age))
            loadUsers()
        }
    }

    private fun loadUsers() {
        _users.value = getUsersUseCase()
    }
}
