package br.com.alura.bytebank.models

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    override var senha: Int,
    var prl: Double
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
), Bonificavel, Autenticavel {
    override val bonificacao: Double get() = salario * 0.1 + salario + prl
}