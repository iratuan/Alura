package br.com.alura.bytebank

fun testandoContas(){

    val iratuan = Analista("Iratuan", "86410768320", 200.0)
    val erika = Gerente("Erika", "88855558885", 300.00, 1213)
    val ian = Diretor("Ian", "88855558885", 300.00, 131, 500.0)
    var funcionarios = mutableListOf<Funcionario>()
    funcionarios.add(iratuan)
    funcionarios.add(erika)
    funcionarios.add(ian)

    var c1 = ContaCorrente(titular = iratuan, numero =123, saldo = 3000.0 )
    var c2 = ContaPoupanca(titular = erika, numero =123, saldo = 3000.0 )
    var c3 = ContaCorrente(titular = ian, numero =123, saldo = 3000.0 )


    c1.deposita(500.0)
    c2.saca(100.0)
    c1.transfere(c3, 500.0)

    println("Saldo da conta de ${c1.titular.nome} é de R$ ${c1.saldo}")
    println("Saldo da conta de ${c2.titular.nome} é de R$ ${c2.saldo}")
    println("Saldo da conta de ${c3.titular.nome} é de R$ ${c3.saldo}")
}