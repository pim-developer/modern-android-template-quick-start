package com.renamecompanyname.renameappname.domain.usecase

import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.repository.UserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): Result<List<User>> {
        return userRepository.getAllUsers()
    }
}
