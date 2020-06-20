package br.com.alura.bytebank

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    override var salario: Double
) : Bonificavel