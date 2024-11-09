package com.renamecompanyname.renameappname.data.source

import com.renamecompanyname.renameappname.data.local.models.User
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import javax.inject.Inject
import javax.inject.Named

class UserRealmLocalDataSource
@Inject
constructor(
    @Named("localRealm") private val localRealm: Realm,
) {
    fun createUser(user: User): Result<User> {
        return try {
            val createdUser = localRealm.writeBlocking {
                copyToRealm(user)
            }
            Result.success(createdUser)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getUser(id: String): Result<User> {
        return try {
            val user = localRealm.query<User>("_id == $0", id).first().find()
            user?.let {
                Result.success(it)
            } ?: Result.failure(NoSuchElementException("User not found"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getAllUsers(): Result<List<User>> {
        return try {
            val users = localRealm.query<User>().find()
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun updateUser(user: User): Result<User> {
        return try {
            val updatedUser = localRealm.writeBlocking {
                val existingUser = query<User>("_id == $0", user._id).first().find()
                existingUser?.let {
                    it.name = user.name
                    it
                } ?: throw NoSuchElementException("User not found")
            }
            Result.success(updatedUser)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun deleteUser(user: User): Result<Unit> {
        return try {
            localRealm.writeBlocking {
                val userToDelete = query<User>("_id == $0", user._id).first().find()
                userToDelete?.let {
                    delete(it)
                } ?: throw NoSuchElementException("User not found")
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
