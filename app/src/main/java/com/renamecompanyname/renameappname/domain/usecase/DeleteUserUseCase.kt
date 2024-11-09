package com.renamecompanyname.renameappname.domain.usecase

import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.repository.LocalUserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val localUserRepository: LocalUserRepository,
) {
    suspend operator fun invoke(user: User): Result<Unit> {
        return localUserRepository.deleteUser(user)
    }
}
