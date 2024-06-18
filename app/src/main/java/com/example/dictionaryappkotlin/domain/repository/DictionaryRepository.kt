package com.example.dictionaryappkotlin.domain.repository

import com.example.dictionaryappkotlin.domain.model.WordItem
import com.example.dictionaryappkotlin.utils.Result
import kotlinx.coroutines.flow.Flow

/**
 * AUTHOR Syed Ahmed Kamal, CREATED ON (6/18/2024).
 */
interface DictionaryRepository {
    suspend fun getWordResult(word:String): Flow<Result<WordItem>>
}