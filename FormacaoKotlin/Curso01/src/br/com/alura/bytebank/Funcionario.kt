package br.com.alura.bytebank

abstract class Funcionario (
    val nome:String,
    val cpf:String,
    var salario:Double
): Bonificavel {
    override val bonificacao: Double get() = salario * 0.1
}