package br.com.alura.bytebank

interface Bonificavel {
    var salario:Double
    val bonificacao: Double get() = salario * 0.1
}