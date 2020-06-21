package br.com.alura.bytebank.testes

import br.com.alura.bytebank.models.Cliente
import br.com.alura.bytebank.models.Diretor
import br.com.alura.bytebank.models.Gerente

fun testeLogin(){
    val erika = Gerente("Erika", "88855558885", 300.00, 1213)
    val ian = Diretor("Ian", "88855558885", 300.00, 131, 500.0)
    val iratuan = Cliente("Iratuan", "86410768320", 123)

    println("*********************************************************************************")
    println("TESTANDO OS LOGINS DE FUNCIONARIOS")
    println("*********************************************************************************")
    println("Verificando se o funcionario ${erika.nome} autentica com a senha 3121: ${erika.autentica(3212)}")
    println("Verificando se o funcionario ${ian.nome} autentica com a senha 131: ${ian.autentica(131)}")
    println("Verificando se o funcionario ${iratuan.nome} autentica com a senha 123: ${iratuan.autentica(123)}")
    println("\n\n")
}