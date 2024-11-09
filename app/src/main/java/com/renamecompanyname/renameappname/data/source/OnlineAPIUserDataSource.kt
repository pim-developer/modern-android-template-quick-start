package com.renamecompanyname.renameappname.data.source

import com.renamecompanyname.renameappname.network.KtorClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class OnlineAPIUserDataSource {
    suspend fun fetchSomeData(): HttpResponse {
        return KtorClient.httpClient.get(
            "https://hacker-news.firebaseio.com/v0/item/8863.json?print=pretty",
        )
    }
}
