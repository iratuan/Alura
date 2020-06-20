package br.com.alura.bytebank

fun testeLogin(){
    val erika = Gerente("Erika", "88855558885", 300.00, 1213)
    val ian = Diretor("Ian", "88855558885", 300.00, 131, 500.0)
    val iratuan = Cliente("Iratuan","86410768320", 123)

    println("Verificando se o funcionario ${erika.nome} autentica com a senha 3121: ${erika.autentica(3212)}")
    println("Verificando se o funcionario ${ian.nome} autentica com a senha 3121: ${ian.autentica(131)}")
    println("Verificando se o funcionario ${iratuan.nome} autentica com a senha 123: ${iratuan.autentica(123)}")

}