package com.example.android4a.data.remote


import com.example.android4a.domain.entity.RestPokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokeApi {
    @GET("data.json")
    fun getPokemonResponse(): Call<RestPokemonResponse>
}