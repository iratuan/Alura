package br.com.alura.bytebank.testes

import br.com.alura.bytebank.models.*

fun testeContas() {

    val iratuan = Cliente(
        "Iratuan",
        "86410768320", 120,
        Endereco("Rua P", "265", "60751380")
    )
    val erika = Cliente(
        "Erika",
        "88855558885", 321,
        Endereco("Rua P", "265", "60751380")
    )
    val ian = Cliente(
        "Ian",
        "88855558885", 132,
        Endereco("Rua P", "265", "60751380")
    )
    var clientes = mutableListOf<Cliente>()
    clientes.add(iratuan)
    clientes.add(erika)
    clientes.add(ian)

    var c1 =
        ContaCorrente(titular = iratuan, numero = 123, saldo = 3000.0)
    var c2 =
        ContaPoupanca(titular = erika, numero = 123, saldo = 3000.0)
    var c3 = ContaCorrente(titular = ian, numero = 123, saldo = 3000.0)


    c1.deposita(500.0)
    c2.saca(100.0)
    c1.transfere(c3, 500.0)

    println("*********************************************************************************")
    println("TESTANDO AS CONTAS DE CLIENTES")
    println("*********************************************************************************")
    println("Saldo da conta de ${c1.titular.nome} que mora em ${c1.titular.endereco} é de R$ ${c1.saldo}")
    println("Saldo da conta de ${c2.titular.nome} que mora em ${c2.titular.endereco} é de R$ ${c2.saldo}")
    println("Saldo da conta de ${c3.titular.nome} que mora em ${c3.titular.endereco} é de R$ ${c3.saldo}")
    println("Total de contas criadas foi de ${Conta.total}")
    println("\n\n")
}