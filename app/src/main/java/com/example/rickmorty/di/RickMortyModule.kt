package com.example.rickmorty.di

import com.example.rickmorty.data.repository.CharacterRepository
import com.example.rickmorty.data.source.network.CharacterServiceApi
import com.example.rickmorty.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RickMortyModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterServiceApi(retrofit: Retrofit): CharacterServiceApi{
        return retrofit.create(CharacterServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(characterServiceApi: CharacterServiceApi): CharacterRepository{
        return CharacterRepository(characterServiceApi)
    }
}