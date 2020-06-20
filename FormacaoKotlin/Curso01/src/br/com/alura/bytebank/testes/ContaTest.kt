package br.com.alura.bytebank.testes

import br.com.alura.bytebank.Conta

fun main() {
    var c1 = Conta("Francisco Iratua Nobre Junior", 110110, 3000.00)
    var c2 = Conta("Erika", 25, 3000.00)
    println(c2.saldo)
    c1.transfere(c2, 200.0)
    println(c2.saldo)
}
