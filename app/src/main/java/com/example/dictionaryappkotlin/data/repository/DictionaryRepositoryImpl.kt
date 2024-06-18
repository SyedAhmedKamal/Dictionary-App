package com.example.dictionaryappkotlin.data.repository

import android.app.Application
import android.net.http.HttpException
import com.example.dictionaryappkotlin.data.api.DictionaryApi
import com.example.dictionaryappkotlin.data.toWordItem
import com.example.dictionaryappkotlin.domain.model.WordItem
import com.example.dictionaryappkotlin.domain.repository.DictionaryRepository
import com.example.dictionaryappkotlin.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

/**
 * AUTHOR Syed Ahmed Kamal, CREATED ON (6/18/2024).
 */
class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
): DictionaryRepository {
    override suspend fun getWordResult(word: String): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))

            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word)
            } catch (e: retrofit2.HttpException){
                e.printStackTrace()
                emit(Result.Error("Unable to show result"))
                emit(Result.Loading(false))
                return@flow
            } catch (e: IOException){
                e.printStackTrace()
                emit(Result.Error("Unable to show result"))
                emit(Result.Loading(false))
                return@flow
            } catch (e: Exception){
                e.printStackTrace()
                emit(Result.Error("Unable to show result"))
                emit(Result.Loading(false))
                return@flow
            }

            emit(Result.Success(remoteWordResultDto[0].toWordItem()))

            emit(Result.Loading(false))
        }
    }
}