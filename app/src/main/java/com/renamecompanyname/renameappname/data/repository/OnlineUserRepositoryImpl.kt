package com.renamecompanyname.renameappname.data.repository

import com.renamecompanyname.renameappname.data.online.models.SomeFetchedDataDto
import com.renamecompanyname.renameappname.data.online.models.toDomainSomeFetchedData
import com.renamecompanyname.renameappname.data.source.OnlineAPIUserDataSource
import com.renamecompanyname.renameappname.domain.model.SomeFetchedData
import com.renamecompanyname.renameappname.domain.repository.OnlineUserRepository
import io.ktor.client.call.body
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

class OnlineUserRepositoryImpl(
    private val onlineAPIUserDataSource: OnlineAPIUserDataSource,
) : OnlineUserRepository {
    override suspend fun fetchSomeData(): Result<List<SomeFetchedData>> {
        return try {
            val response = onlineAPIUserDataSource.fetchSomeData()
            val jsonObject = Json.parseToJsonElement(response.body<String>()).jsonObject
            val countriesArray = jsonObject["countries"]?.jsonArray
                ?: throw IllegalStateException("Countries array not found in response")
            Result.success(
                Json.decodeFromJsonElement<List<SomeFetchedDataDto>>(countriesArray)
                    .map { it.toDomainSomeFetchedData() },
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
