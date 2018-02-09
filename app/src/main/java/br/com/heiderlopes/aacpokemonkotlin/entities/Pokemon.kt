package br.com.heiderlopes.aacpokemonkotlin.entities

import com.google.gson.annotations.SerializedName

data class Pokemon(
        @field:SerializedName("name")
        val nome: String
)