package br.com.alura.bytebank.models

import br.com.alura.bytebank.models.Autenticavel

class Cliente(
    val nome: String,
    val cpf: String,
    override var senha: Int,
    var endereco: Endereco = Endereco()
) :
    Autenticavel {
}