package com.example.rickmorty.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.rickmorty.data.repository.CharacterRepository
import com.example.rickmorty.data.source.network.models.NetworkCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) :ViewModel() {
    val list: LiveData<PagingData<NetworkCharacter.Result>> =
        characterRepository.fetchCharacterData()
}