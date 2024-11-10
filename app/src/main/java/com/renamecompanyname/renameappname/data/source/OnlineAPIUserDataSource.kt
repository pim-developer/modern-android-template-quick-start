package com.renamecompanyname.renameappname.data.source

import com.renamecompanyname.renameappname.network.KtorClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class OnlineAPIUserDataSource {
    suspend fun fetchSomeData(): HttpResponse {
        return KtorClient.httpClient.get(
            "https://www.thesportsdb.com/api/v1/json/3/all_countries.php",
        )
    }
}
