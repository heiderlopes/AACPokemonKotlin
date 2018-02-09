package br.com.heiderlopes.aacpokemonkotlin.repository

import br.com.heiderlopes.aacpokemonkotlin.entities.ApiResponse
import android.arch.lifecycle.LiveData

interface PokemonRepository {
    fun getPokemon(numero: String): LiveData<ApiResponse>
}