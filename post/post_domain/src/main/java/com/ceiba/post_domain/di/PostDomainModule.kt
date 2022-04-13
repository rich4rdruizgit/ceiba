package com.ceiba.post_domain.di

import com.ceiba.post_domain.repository.PostRepository
import com.ceiba.post_domain.use_case.GetPosts
import com.ceiba.post_domain.use_case.PostUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PostDomainModule {
    @ViewModelScoped
    @Provides
    fun provideAllPostUseCase(
        repository: PostRepository
    ): PostUsesCases {
        return PostUsesCases(
            getPosts = GetPosts(repository)
        )


    }
}