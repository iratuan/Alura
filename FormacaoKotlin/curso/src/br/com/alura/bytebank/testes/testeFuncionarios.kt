package br.com.alura.bytebank.testes

import br.com.alura.bytebank.infra.CalculadoraBonificacao
import br.com.alura.bytebank.models.Analista
import br.com.alura.bytebank.models.Diretor
import br.com.alura.bytebank.models.Funcionario
import br.com.alura.bytebank.models.Gerente

fun testeFuncionarios(){
    val iratuan = Analista("Iratuan", "86410768320", 200.0)
    val erika = Gerente("Erika", "88855558885", 300.00, 1213)
    val ian = Diretor("Ian", "88855558885", 300.00, 131, 500.0)
    var funcionarios = mutableListOf<Funcionario>()
    funcionarios.add(iratuan)
    funcionarios.add(erika)
    funcionarios.add(ian)

    val calculadoraBonificacao = CalculadoraBonificacao()

    for (funcionario in funcionarios ){
        calculadoraBonificacao.registra(funcionario)
    }
    println("*********************************************************************************")
    println("TESTANDO AS BONIFICAÇÕES DE FUNCIONARIOS")
    println("*********************************************************************************")
    println("O total de bonificações foi de R$ ${calculadoraBonificacao.total}")
    println("\n\n")
}