package br.com.heiderlopes.aacpokemonkotlin.ui.pesquisa

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.aacpokemonkotlin.R
import android.arch.lifecycle.ViewModelProviders
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pesquisa.*


class PesquisaActivity : AppCompatActivity() {

    lateinit var mViewModel: PesquisaPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        mViewModel = ViewModelProviders.of(this).get(PesquisaPokemonViewModel::class.java!!)

        btPesquisar.setOnClickListener {
            mViewModel.loadPokemon(etNumeroPokemon.editableText.toString())
        }

        mViewModel.apiResponse.observe(this, Observer { apiResponse ->
            if(apiResponse!!.error == null) {
                tvNomePokemon.text = apiResponse.pokemon!!.nome
            } else {
                Toast.makeText(baseContext, "Deu ruim!!!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
