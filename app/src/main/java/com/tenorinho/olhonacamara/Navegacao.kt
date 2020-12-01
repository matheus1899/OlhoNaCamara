package com.tenorinho.olhonacamara

import com.tenorinho.olhonacamara.models.Sessao
import com.tenorinho.olhonacamara.models.Votacao

interface Navegacao {
    fun navigateToFragmentSessaoDetail(sessao: Sessao?)
    fun navigateToFragmentVotacaoDetail(votacao: Votacao?)
}