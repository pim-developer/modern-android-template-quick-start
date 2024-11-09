package com.renamecompanyname.renameappname.di

import com.renamecompanyname.renameappname.data.repository.UserRepositoryImpl
import com.renamecompanyname.renameappname.data.source.UserRealmLocalDataSource
import com.renamecompanyname.renameappname.domain.repository.UserRepository
import com.renamecompanyname.renameappname.domain.usecase.CreateUserUseCase
import com.renamecompanyname.renameappname.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UserModule {
    @Provides
    fun provideUserRepository(userRealmLocalDataSource: UserRealmLocalDataSource): UserRepository {
        return UserRepositoryImpl(userRealmLocalDataSource)
    }

    @Provides
    fun provideCreateUserUseCase(userRepository: UserRepository): CreateUserUseCase {
        return CreateUserUseCase(userRepository)
    }

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }
}
