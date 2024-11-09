package com.renamecompanyname.renameappname.data.source

import com.renamecompanyname.renameappname.data.local.models.User
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import javax.inject.Inject
import javax.inject.Named

class LocalRealmUserDataSource
@Inject
constructor(
    @Named("localRealm") private val localRealm: Realm,
) {
    fun createUser(user: User): User {
        return localRealm.writeBlocking {
            copyToRealm(user)
        }
    }

    fun getUser(id: String): User {
        return localRealm.query<User>("_id == $0", id).first().find()
            ?: throw NoSuchElementException("User not found")
    }

    fun getAllUsers(): List<User> {
        return localRealm.query<User>().find()
    }

    fun updateUser(user: User): User {
        return localRealm.writeBlocking {
            val existingUser = query<User>("_id == $0", user._id).first().find()
            existingUser?.let {
                it.name = user.name
                it
            } ?: throw NoSuchElementException("User not found")
        }
    }

    fun deleteUser(user: User) {
        localRealm.writeBlocking {
            val userToDelete = query<User>("_id == $0", user._id).first().find()
            userToDelete?.let {
                delete(it)
            } ?: throw NoSuchElementException("User not found")
        }
    }
}
