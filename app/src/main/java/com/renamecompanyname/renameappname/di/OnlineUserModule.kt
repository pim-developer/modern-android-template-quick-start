package com.renamecompanyname.renameappname.di

import com.renamecompanyname.renameappname.data.repository.OnlineUserRepositoryImpl
import com.renamecompanyname.renameappname.data.source.OnlineAPIUserDataSource
import com.renamecompanyname.renameappname.domain.repository.OnlineUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OnlineUserModule {
    @Provides
    fun provideOnlineUserRepository(
        onlineAPIUserDataSource: OnlineAPIUserDataSource,
    ): OnlineUserRepository {
        return OnlineUserRepositoryImpl(onlineAPIUserDataSource)
    }
}
