package br.com.alura.bytebank.models

interface Bonificavel {
    var salario:Double
    val bonificacao: Double get() = salario * 0.1
}