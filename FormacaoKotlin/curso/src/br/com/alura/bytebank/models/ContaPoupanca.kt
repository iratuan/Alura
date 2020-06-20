package br.com.alura.bytebank.models

class ContaPoupanca(
    titular: Funcionario,
    numero: Int,
    saldo: Double) : Conta(
    titular = titular,
    numero = numero,
    saldo = saldo) {

}