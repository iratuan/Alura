package br.com.alura.bytebank.models

class ContaPoupanca(
    titular: Cliente,
    numero: Int,
    saldo: Double) : Conta(
    titular = titular,
    numero = numero,
    saldo = saldo) {

}