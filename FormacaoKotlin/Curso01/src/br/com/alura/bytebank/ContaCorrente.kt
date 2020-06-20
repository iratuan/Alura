package br.com.alura.bytebank

class ContaCorrente(
    titular: Funcionario,
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