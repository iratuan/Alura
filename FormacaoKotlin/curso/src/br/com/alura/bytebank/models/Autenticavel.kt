package br.com.alura.bytebank.models

interface Autenticavel {
    var senha:Int
    fun autentica(senha: Int): Boolean {
        if(this.senha != senha) return false
        return true
    }
}