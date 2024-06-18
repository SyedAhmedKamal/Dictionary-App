package com.example.dictionaryappkotlin.di

import com.example.dictionaryappkotlin.data.api.DictionaryApi
import com.example.dictionaryappkotlin.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * AUTHOR Syed Ahmed Kamal, CREATED ON (6/18/2024).
 */
@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    private val intercepotr: HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor = intercepotr)
        .build()

    @Provides
    @Singleton
    fun providesDictionaryApi(): DictionaryApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build().create()
    }
}