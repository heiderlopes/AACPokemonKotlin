package br.com.heiderlopes.aacpokemonkotlin.api

import br.com.heiderlopes.aacpokemonkotlin.entities.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("api/v2/pokemon/{numero}")
    fun getPokemon(@Path("numero") numero: String): Call<Pokemon>
}