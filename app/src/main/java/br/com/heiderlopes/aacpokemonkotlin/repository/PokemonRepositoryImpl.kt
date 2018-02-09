package br.com.heiderlopes.aacpokemonkotlin.repository

import br.com.heiderlopes.aacpokemonkotlin.entities.ApiResponse
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData
import br.com.heiderlopes.aacpokemonkotlin.api.GithubApiService
import br.com.heiderlopes.aacpokemonkotlin.entities.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class PokemonRepositoryImpl : PokemonRepository {

    override fun getPokemon(numero: String): LiveData<ApiResponse> {
        val liveData = MutableLiveData<ApiResponse>()
        val call = mApiService.getPokemon(numero)
        call.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                liveData.value = ApiResponse(response.body())
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                liveData.value = ApiResponse(t)
            }
        })
        return liveData
    }

    private val mApiService: GithubApiService

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        mApiService = retrofit.create(GithubApiService::class.java)
    }


    companion object {

        val BASE_URL = "https://pokeapi.co/"
    }

}