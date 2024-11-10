package com.renamecompanyname.renameappname.domain.repository

import com.renamecompanyname.renameappname.domain.model.SomeFetchedData

interface OnlineUserRepository {
    suspend fun fetchSomeData(): Result<List<SomeFetchedData>>
}
