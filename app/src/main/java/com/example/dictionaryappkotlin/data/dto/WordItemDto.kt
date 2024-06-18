package com.example.dictionaryappkotlin.data.dto

data class WordItemDto(
    val meanings: List<MeaningDto>,
    val phonetics: String,
    val word: String
)