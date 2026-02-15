package entradaSalida

import Divisas

fun menu(): Int{
    limpiarPantalla()
    println("CONVERSOR DE DIVISAS")
    println("--------------------")
    println("1.- Conversión de divisas")
    println("2.- Cambio de tasas")
    println("3.- Salir")
    print("Selecciona una opción: ")

    return readLine()?.toIntOrNull() ?: 0
}

fun esperarIntro(mensaje: String){
    print(mensaje)
    readLine()
}

fun limpiarPantalla() {
    val os = System.getProperty("os.name").lowercase()

    if (os.contains("win")) {
        ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
    } else {
        ProcessBuilder("clear").inheritIO().start().waitFor()
    }
}

fun leerValor(mensaje: String): Double{
    limpiarPantalla()
    print(mensaje)
    return readLine()?.toDouble() ?: -1.0
}

fun imprimeResultado(monto: Double, divisaOrigen: Int, conversion: Double, divisaDestino: Int){
    println("$monto ${Divisas.entries[divisaOrigen]} = %.2f ${Divisas.entries[divisaDestino]}"
        .format(conversion))
}

fun leerDivisa(textoEntrada: String): Int {
    var divisa: Int
    do {
        limpiarPantalla()
        Divisas.entries.mapIndexed { index, divisa -> println("$index -- $divisa") }
        print(textoEntrada)
        divisa = readLine()?.toIntOrNull() ?: -1
    } while (divisa !in Divisas.entries.indices)
    return divisa
}