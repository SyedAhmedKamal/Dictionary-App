package com.example.dictionaryappkotlin.domain.model

/**
 * AUTHOR Syed Ahmed Kamal, CREATED ON (6/18/2024).
 */
data class WordItem(
    val word:String,
    val meanings: List<Meaning>,
    val phonetic: String
)
