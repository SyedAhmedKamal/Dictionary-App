package com.example.dictionaryappkotlin.data.dto

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
)