package br.com.alura.bytebank.models

import br.com.alura.bytebank.models.Autenticavel
import br.com.alura.bytebank.models.Bonificavel
import br.com.alura.bytebank.models.Funcionario

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    override var senha: Int
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
), Bonificavel, Autenticavel {
    override val bonificacao: Double get() = salario * 0.1 + this.salario
}