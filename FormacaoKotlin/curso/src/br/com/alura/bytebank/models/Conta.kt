package br.com.alura.bytebank.models

import br.com.alura.bytebank.exceptions.SaldoInsuficienteException

abstract class Conta(val titular: Cliente, val numero: Int, saldo: Double) {

    var saldo = saldo
        protected set


    /**
     * Análogo a uma variável estática
     * */
    companion object Contador {
        var total: Int = 0
            private set
    }

    /**
     * Incrementa o contador global
     * */
    init {
        Conta.total++
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    open fun saca(valor: Double) {
        if (saldo < valor) {
            SaldoInsuficienteException().message
        }
        this.saldo -= valor

    }

    fun transfere(destino: Conta, valor: Double): Boolean {
        if (saldo < valor) {
            SaldoInsuficienteException().message
        }
        this.saca(valor)
        destino.deposita(valor)
        return true
    }
}