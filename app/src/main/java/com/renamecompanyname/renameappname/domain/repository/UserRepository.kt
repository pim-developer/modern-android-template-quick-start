package com.renamecompanyname.renameappname.domain.repository

import com.renamecompanyname.renameappname.domain.model.User

interface UserRepository {
    suspend fun createUser(user: User): Result<User>
    suspend fun getUser(id: String): Result<User>
    suspend fun getAllUsers(): Result<List<User>>
    suspend fun updateUser(user: User): Result<User>
    suspend fun deleteUser(user: User): Result<Unit>
}
