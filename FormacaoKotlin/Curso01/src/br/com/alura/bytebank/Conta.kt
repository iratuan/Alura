package br.com.alura.bytebank

import java.lang.Exception

class Conta(val titular: String, val numero: Int, var saldo: Double) {

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
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