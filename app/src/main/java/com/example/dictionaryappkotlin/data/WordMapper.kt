package com.example.dictionaryappkotlin.data

import com.example.dictionaryappkotlin.data.dto.DefinitionDto
import com.example.dictionaryappkotlin.data.dto.MeaningDto
import com.example.dictionaryappkotlin.data.dto.WordItemDto
import com.example.dictionaryappkotlin.domain.model.Definition
import com.example.dictionaryappkotlin.domain.model.Meaning
import com.example.dictionaryappkotlin.domain.model.WordItem

/**
 * AUTHOR Syed Ahmed Kamal, CREATED ON (6/18/2024).
 */

fun WordItemDto.toWordItem() = WordItem(
    word = word ?: "",
    meanings = meanings.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetics ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions[0]),
    partOfSpeech = partOfSpeech ?: ""
)

fun definitionDtoToDefinition(
    definitionDto: DefinitionDto
) = Definition(
    definition = definitionDto.definition ?: "",
    example = definitionDto.example ?: ""
)