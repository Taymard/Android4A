package com.example.android4a.domain.entity

data class RestPokemonResponse (
    val count: Int,
    val next: String ,
    val results: List<Pokemon>
) {
}