package com.renamecompanyname.renameappname.data.repository

import com.renamecompanyname.renameappname.data.source.OnlineAPIUserDataSource
import com.renamecompanyname.renameappname.domain.model.SomeFetchedData
import com.renamecompanyname.renameappname.domain.repository.OnlineUserRepository
import io.ktor.client.call.body
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

class OnlineUserRepositoryImpl(
    private val onlineAPIUserDataSource: OnlineAPIUserDataSource,
) : OnlineUserRepository {
    override suspend fun fetchSomeData(): Result<SomeFetchedData> {
        return try {
            val response = onlineAPIUserDataSource.fetchSomeData()
            val jsonString = response.body<String>()
            val jsonObject = Json.parseToJsonElement(jsonString).jsonObject
            val title = jsonObject["title"]?.toString()?.trim('"') ?: ""
            Result.success(SomeFetchedData(summary = title))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
