package br.com.alura.bytebank.exceptions

import java.lang.Exception

class SaldoInsuficienteException(mensagem: String = "O saldo é insuficiente") : Exception(mensagem)