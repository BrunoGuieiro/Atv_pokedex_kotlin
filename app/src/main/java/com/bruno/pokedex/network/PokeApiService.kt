package com.bruno.pokedex.network

import com.bruno.pokedex.model.PokemonDetailResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{nameOrId}")
    suspend fun getPokemon(@Path("nameOrId") nameOrId: String): PokemonDetailResponse
}

object RetrofitClient {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val apiService: PokeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApiService::class.java)
    }
}