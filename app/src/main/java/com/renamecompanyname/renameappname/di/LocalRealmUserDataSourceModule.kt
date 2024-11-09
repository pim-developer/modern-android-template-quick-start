package com.renamecompanyname.renameappname.di

import com.renamecompanyname.renameappname.data.local.models.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalRealmUserDataSourceModule {
    @Provides
    @Singleton
    @Named("localRealm")
    fun provideLocalRealmInstance(): Realm {
        return Realm.open(
            RealmConfiguration.create(
                schema = setOf(User::class),
            ),
        )
    }
}
