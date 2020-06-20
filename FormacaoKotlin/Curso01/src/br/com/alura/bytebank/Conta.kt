package br.com.alura.bytebank

import java.lang.Exception

class Conta {
    var titular = ""
    var numero = 0
    var saldo = 0.0

    fun deposita(valor: Double) {
        this.saldo += valor
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        } else {
            println("Valor de saque não permitido")
        }
    }

    fun transfere(destino:Conta, valor:Double): Boolean{
        if(this.saldo >= valor){
            this.saca(valor)
            destino.deposita(valor)
            return true
        }else{
            return false
        }
    }
}