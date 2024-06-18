package com.example.dictionaryappkotlin.data.api

import com.example.dictionaryappkotlin.data.dto.WordResultDto
import com.example.dictionaryappkotlin.utils.Constants.WORD_END_POINT
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * AUTHOR Syed Ahmed Kamal, CREATED ON (6/18/2024).
 */
interface DictionaryApi {
    @GET(WORD_END_POINT)
    suspend fun getWordResult(@Path("word") word:String): WordResultDto
}