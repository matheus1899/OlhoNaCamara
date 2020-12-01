package com.tenorinho.olhonacamara.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tenorinho.olhonacamara.Navegacao
import com.tenorinho.olhonacamara.R
import com.tenorinho.olhonacamara.models.Sessao
import com.tenorinho.olhonacamara.models.Votacao
import com.tenorinho.olhonacamara.ui.fragments.*

class MainActivity : AppCompatActivity(), Navegacao {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.main_activity_frame, SessoesFragments.create(),"").commit()
        }
    }
    override fun navigateToFragmentSessaoDetail(sessao: Sessao?) {
        val detailFragment:SessaoDetailFragment = SessaoDetailFragment.create()
        detailFragment.setSessao(sessao)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_frame, detailFragment)
            .addToBackStack("teste")
            .commit()
    }

    override fun navigateToFragmentVotacaoDetail(votacao: Votacao?) {
        val detailFragment:VotacaoDetailFragment = VotacaoDetailFragment.create()
        detailFragment.setVotacao(votacao)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_frame, detailFragment)
            .addToBackStack("teste2")
            .commit()
    }
}
