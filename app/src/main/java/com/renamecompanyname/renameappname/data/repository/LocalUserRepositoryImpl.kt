package com.renamecompanyname.renameappname.data.repository

import com.renamecompanyname.renameappname.data.local.models.toDataUser
import com.renamecompanyname.renameappname.data.local.models.toDomainUser
import com.renamecompanyname.renameappname.data.source.LocalRealmUserDataSource
import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.repository.LocalUserRepository

class LocalUserRepositoryImpl(
    private val localRealmUserDataSource: LocalRealmUserDataSource,
) : LocalUserRepository {

    override suspend fun createUser(user: User): Result<User> {
        return try {
            val createdUser = localRealmUserDataSource.createUser(user.toDataUser()).toDomainUser()
            Result.success(createdUser)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getUser(id: String): Result<User> {
        return try {
            val user = localRealmUserDataSource.getUser(id).toDomainUser()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAllUsers(): Result<List<User>> {
        return try {
            val users = localRealmUserDataSource.getAllUsers().map { it.toDomainUser() }
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateUser(user: User): Result<User> {
        return try {
            val updatedUser = localRealmUserDataSource.updateUser(user.toDataUser()).toDomainUser()
            Result.success(updatedUser)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteUser(user: User): Result<Unit> {
        return try {
            localRealmUserDataSource.deleteUser(user.toDataUser())
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
