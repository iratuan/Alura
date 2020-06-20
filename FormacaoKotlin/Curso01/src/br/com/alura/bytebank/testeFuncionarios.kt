package br.com.alura.bytebank

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
        println("Adicionando o funcionario ${funcionario.nome} à lista de calculos.")
        calculadoraBonificacao.registra(funcionario)
    }
    println("O total de bonificações foi de R$ ${calculadoraBonificacao.total}")
}