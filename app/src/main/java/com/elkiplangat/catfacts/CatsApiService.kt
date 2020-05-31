package com.elkiplangat.catfacts

import retrofit2.Call
import retrofit2.Retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://catfact.ninja/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    BASE_URL).build()

interface CatsApiService {
    @GET("fact?max_length=140")
    fun getCatFacts():Call<CatFact>

    object CatsApi{
        val retrofitService :CatsApiService by lazy {
            retrofit.create(CatsApiService::class.java)
        }
    }

}