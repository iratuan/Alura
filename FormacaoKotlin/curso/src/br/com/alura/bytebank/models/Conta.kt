package br.com.alura.bytebank.models

abstract class Conta(val titular: Funcionario, val numero: Int, saldo: Double) {

    var saldo = saldo
        protected set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    open fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        } else {
            println("Valor de saque não permitido")
        }
    }

    fun transfere(destino: Conta, valor: Double): Boolean {
        if (this.saldo >= valor) {
            this.saca(valor)
            destino.deposita(valor)
            return true
        } else {
            return false
        }
    }
}