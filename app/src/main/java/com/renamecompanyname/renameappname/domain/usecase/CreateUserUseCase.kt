package com.renamecompanyname.renameappname.domain.usecase

import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.repository.LocalUserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val localUserRepository: LocalUserRepository,
) {
    suspend operator fun invoke(user: User): Result<User> {
        return localUserRepository.createUser(user)
    }
}
