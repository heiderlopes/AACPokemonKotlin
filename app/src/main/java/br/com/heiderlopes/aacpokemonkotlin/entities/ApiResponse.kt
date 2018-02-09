package br.com.heiderlopes.aacpokemonkotlin.entities

class ApiResponse {
    var pokemon: Pokemon?
    var error: Throwable? = null

    constructor(pokemon: Pokemon) {
        this.pokemon = pokemon
        this.error = null
    }

    constructor(error: Throwable) {
        this.error = error
        this.pokemon = null
    }
}