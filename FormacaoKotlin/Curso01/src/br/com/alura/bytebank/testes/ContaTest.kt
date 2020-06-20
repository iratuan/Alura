package br.com.alura.bytebank.testes

import br.com.alura.bytebank.Conta

fun main() {
    var c1 = Conta()
    c1.titular = "Francisco Iratua Nobre Junior"
    c1.numero = 110110
    c1.saldo = 3000.00

    var c2 = Conta()
    c2.titular = "Erika"
    c2.numero = 25
    c2.saldo = 3000.00


    println(c2.saldo)
    c1.transfere(c2,200.0)
    println(c2.saldo)


}
