package br.com.alura.bytebank.models

class ContaCorrente(
    titular: Cliente,
    numero: Int,
    saldo: Double
) : Conta(
    titular = titular,
    numero = numero,
    saldo = saldo) {

    override fun saca(valor: Double) {
        val valorComTaxa = valor + 0.1
        super.saca(valorComTaxa)
    }
}