package br.com.alura.bytebank

class ContaPoupanca(
    titular: Funcionario,
    numero: Int,
    saldo: Double) : Conta(
    titular = titular,
    numero = numero,
    saldo = saldo) {

}