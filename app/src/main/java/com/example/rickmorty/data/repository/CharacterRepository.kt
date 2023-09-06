package com.example.rickmorty.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickmorty.data.source.network.CharacterServiceApi
import com.example.rickmorty.data.source.network.models.NetworkCharacter
import com.example.rickmorty.paging.CharacterPagingSource

class CharacterRepository(
    private val characterServiceApi: CharacterServiceApi
) {
    fun fetchCharacterData(): LiveData<PagingData<NetworkCharacter.Result>> = Pager(
        config = PagingConfig(
            20,
            5,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            CharacterPagingSource(characterServiceApi)
        }
    ).liveData
}