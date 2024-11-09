package com.renamecompanyname.renameappname.domain.usecase

import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.repository.LocalUserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val localUserRepository: LocalUserRepository,
) {
    suspend operator fun invoke(): Result<List<User>> {
        return localUserRepository.getAllUsers()
    }
}
