package br.com.heiderlopes.aacpokemonkotlin.ui.pesquisa

import br.com.heiderlopes.aacpokemonkotlin.entities.ApiResponse
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import br.com.heiderlopes.aacpokemonkotlin.repository.PokemonRepository
import br.com.heiderlopes.aacpokemonkotlin.repository.PokemonRepositoryImpl


class PesquisaPokemonViewModel : ViewModel() {

    private val mApiResponse: MediatorLiveData<ApiResponse> = MediatorLiveData()
    private val mPokemonRepository: PokemonRepository

    val apiResponse: LiveData<ApiResponse>
        get() = mApiResponse

    init {
        mPokemonRepository = PokemonRepositoryImpl()
    }

    fun loadPokemon(numero: String): LiveData<ApiResponse> {
        mApiResponse.addSource(
                mPokemonRepository.getPokemon(numero)
        ) { apiResponse -> mApiResponse.setValue(apiResponse) }
        return mApiResponse
    }

}