package br.com.alura.bytebank.infra

import br.com.alura.bytebank.exceptions.NotFuncionarioException
import br.com.alura.bytebank.models.Bonificavel

class CalculadoraBonificacao {
    var total: Double = 0.0
        private set

    fun registra(funcionario: Bonificavel) {
        try {
            this.total += funcionario.bonificacao
        }catch (exception: ClassCastException){
            println(exception.message)
        }
    }
}