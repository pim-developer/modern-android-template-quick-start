package com.renamecompanyname.renameappname.data.repository

import com.renamecompanyname.renameappname.data.local.models.toDataUser
import com.renamecompanyname.renameappname.data.local.models.toDomainUser
import com.renamecompanyname.renameappname.data.source.UserRealmLocalDataSource
import com.renamecompanyname.renameappname.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userRealmLocalDataSource: UserRealmLocalDataSource,
) : UserRepository {

    override suspend fun createUser(
        user: com.renamecompanyname.renameappname.domain.model.User,
    ): Result<com.renamecompanyname.renameappname.domain.model.User> {
        return userRealmLocalDataSource.createUser(user.toDataUser()).map { it.toDomainUser() }
    }

    override suspend fun getUser(
        id: String,
    ): Result<com.renamecompanyname.renameappname.domain.model.User> {
        return userRealmLocalDataSource.getUser(id).map { it.toDomainUser() }
    }

    override suspend fun getAllUsers():
        Result<List<com.renamecompanyname.renameappname.domain.model.User>> {
        return userRealmLocalDataSource.getAllUsers().map { users ->
            users.map { it.toDomainUser() }
        }
    }

    override suspend fun updateUser(
        user: com.renamecompanyname.renameappname.domain.model.User,
    ): Result<com.renamecompanyname.renameappname.domain.model.User> {
        return userRealmLocalDataSource.updateUser(user.toDataUser()).map { it.toDomainUser() }
    }

    override suspend fun deleteUser(
        user: com.renamecompanyname.renameappname.domain.model.User,
    ): Result<Unit> {
        return userRealmLocalDataSource.deleteUser(user.toDataUser())
    }
}
