package br.com.alura.bytebank

class CalculadoraBonificacao {
    var total: Double = 0.0
        private set

    fun registra(funcionario: Bonificavel) {
        this.total += funcionario.bonificacao
    }
}