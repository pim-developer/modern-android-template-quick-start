package com.renamecompanyname.renameappname.domain.usecase

import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.repository.LocalUserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val localUserRepository: LocalUserRepository,
) {
    suspend operator fun invoke(id: String): Result<User> {
        return localUserRepository.getUser(id)
    }
}
