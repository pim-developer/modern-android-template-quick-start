package com.renamecompanyname.renameappname.domain.usecase

import com.renamecompanyname.renameappname.domain.model.SomeFetchedData
import com.renamecompanyname.renameappname.domain.repository.OnlineUserRepository
import javax.inject.Inject

class FetchSomeDataUseCase @Inject constructor(
    private val onlineUserRepository: OnlineUserRepository,
) {
    suspend operator fun invoke(): Result<List<SomeFetchedData>> {
        return onlineUserRepository.fetchSomeData()
    }
}
