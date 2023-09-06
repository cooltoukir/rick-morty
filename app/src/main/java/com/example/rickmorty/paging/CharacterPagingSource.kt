package com.example.rickmorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickmorty.data.source.network.CharacterServiceApi
import com.example.rickmorty.data.source.network.models.NetworkCharacter
import com.example.rickmorty.utils.Constants.STARTING_INDEX
import retrofit2.HttpException
import java.io.IOException

class CharacterPagingSource(
    private val characterServiceApi: CharacterServiceApi
): PagingSource<Int, NetworkCharacter.Result>() {
    override fun getRefreshKey(state: PagingState<Int, NetworkCharacter.Result>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NetworkCharacter.Result> {
        val position = params.key?: STARTING_INDEX
        return try {
            val data = characterServiceApi.getAllCharacter(position)
            LoadResult.Page(
                data = data.results,
                prevKey = if (params.key == STARTING_INDEX) null else position -1,
                nextKey = if(data.results.isEmpty()) null else position + 1
            )
        } catch (e:IOException) {
            LoadResult.Error(e)
        } catch (e:HttpException) {
            LoadResult.Error(e)
        }
    }
}