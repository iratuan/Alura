package br.com.alura.bytebank

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: Int,
    var prl: Double
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario), Bonificavel {

    override val bonificacao: Double get() = super.bonificacao + salario + prl

    fun autentica(senha: Int): Boolean {
        if (this.senha != senha) {
            return false
        }
        return true
    }
}