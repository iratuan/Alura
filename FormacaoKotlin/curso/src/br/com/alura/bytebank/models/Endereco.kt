package br.com.alura.bytebank.models

class Endereco(var logradouro:String = "", var numero:String = "", var cep:String = "" ){

    override fun toString():String {
        return "Endereço: ${logradouro}, Nº ${numero}, CEP ${cep}"
    }

    override fun equals(other: Any?): Boolean {
        if(other != null && other is Endereco){
            return this.cep == other.cep
        }
        return false
    }

}