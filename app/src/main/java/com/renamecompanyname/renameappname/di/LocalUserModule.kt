package com.renamecompanyname.renameappname.di

import com.renamecompanyname.renameappname.data.repository.LocalUserRepositoryImpl
import com.renamecompanyname.renameappname.data.source.LocalRealmUserDataSource
import com.renamecompanyname.renameappname.domain.repository.LocalUserRepository
import com.renamecompanyname.renameappname.domain.usecase.CreateUserUseCase
import com.renamecompanyname.renameappname.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object LocalUserModule {
    @Provides
    fun provideUserRepository(
        localRealmUserDataSource: LocalRealmUserDataSource,
    ): LocalUserRepository {
        return LocalUserRepositoryImpl(localRealmUserDataSource)
    }

    @Provides
    fun provideCreateUserUseCase(localUserRepository: LocalUserRepository): CreateUserUseCase {
        return CreateUserUseCase(localUserRepository)
    }

    @Provides
    fun provideGetUserUseCase(localUserRepository: LocalUserRepository): GetUserUseCase {
        return GetUserUseCase(localUserRepository)
    }
}
