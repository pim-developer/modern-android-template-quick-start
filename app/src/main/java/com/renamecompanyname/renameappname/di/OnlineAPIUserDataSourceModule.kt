package com.renamecompanyname.renameappname.di

import com.renamecompanyname.renameappname.data.source.OnlineAPIUserDataSource
import com.renamecompanyname.renameappname.domain.repository.OnlineUserRepository
import com.renamecompanyname.renameappname.domain.usecase.FetchSomeDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnlineAPIUserDataSourceModule {
    @Provides
    @Singleton
    fun provideUserOnlineAPIDataSourceModule(): OnlineAPIUserDataSource {
        return OnlineAPIUserDataSource()
    }

    @Provides
    fun provideCreateUserUseCase(onlineUserRepository: OnlineUserRepository): FetchSomeDataUseCase {
        return FetchSomeDataUseCase(onlineUserRepository)
    }
}
