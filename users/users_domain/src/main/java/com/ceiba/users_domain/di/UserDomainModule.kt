package com.ceiba.users_domain.di

import com.ceiba.users_domain.repository.UserRepository
import com.ceiba.users_domain.use_cases.GetUsers
import com.ceiba.users_domain.use_cases.GetUsersByName
import com.ceiba.users_domain.use_cases.UsersUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UserDomainModule {

    @ViewModelScoped
    @Provides
    fun provideUsersUseCases(
        repository: UserRepository
    ): UsersUseCases {
        return UsersUseCases(
            getUsers = GetUsers(repository),
            getUsersByName = GetUsersByName(repository)
        )
    }
}