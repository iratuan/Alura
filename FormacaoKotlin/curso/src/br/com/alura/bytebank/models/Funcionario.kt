package br.com.alura.bytebank.models

import br.com.alura.bytebank.models.Bonificavel

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    override var salario: Double
) : Bonificavel