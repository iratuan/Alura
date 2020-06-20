package br.com.alura.bytebank

import br.com.alura.bytebank.Autenticavel

class Cliente (val nome:String, val cpf: String, override var senha:Int) : Autenticavel {
}