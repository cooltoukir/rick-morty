package com.example.rickmorty.data.source.network

import com.example.rickmorty.data.source.network.models.NetworkCharacter
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterServiceApi {
    @GET("character")
    suspend fun getAllCharacter(
        @Query("page") page: Int
    ): NetworkCharacter
}