/**
 * Punto de entrada de la aplicación
 */

fun main() {
//    val eurUsd = convertirMonto(100.0,Divisas.Euros,Divisas.Dolares)
//    println("${Divisas.Euros.ordinal} , ${Divisas.Dolares.ordinal}")
//    println("100 Euros: %.2f dolares".format(eurUsd))
    var opcion: Int
    val tablaDeTasas = TablaTasas()

    var tablaDeTasasAplicable = tablaDeTasas

    do {
        limpiarPantalla()
        println("CONVERSOR DE DIVISAS")
        println("--------------------")
        println("1.- Conversión de divisas")
        println("2.- Cambio de tasas")
        println("3.- Salir")
        print("Selecciona una opción: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                limpiarPantalla()
                print("Introduce el monto: ")
                val monto = readLine()?.toDoubleOrNull() ?: -1.0
                if (monto > -1) {
                    val divisaOrigen = leerDivisa("Selecciona divisa origen: ")
                    val divisaDestino = leerDivisa("Selecciona divisa destino: ")
                    val conversion = convertirMonto(
                        tablaDeTasasAplicable, monto, Divisas.entries[divisaOrigen],
                        Divisas.entries[divisaDestino]
                    )
                    println("$monto ${Divisas.entries[divisaOrigen]} = %.2f ${Divisas.entries[divisaDestino]}"
                        .format(conversion))
                }
            }
            2 -> {
                limpiarPantalla()
                val nuevaTasa = readLine()?.toDoubleOrNull() ?: -1.0
                if (nuevaTasa > -1) {
                    val tablaDivisas = leerDivisa("Selecciona la tabla de divisas a modificar: ")
                    val divisaModificada = leerDivisa("Selecciona la divisa a modificar la tasa: ")
                    tablaDeTasasAplicable = actualizarTasas(tablaDeTasasAplicable,
                        nuevaTasa,
                        Divisas.entries.get(tablaDivisas),
                        Divisas.entries.get(divisaModificada))
                }else{
                    println("Tasa incorrecta! - Pulsa INTRO para continuar")
                    readLine()
                }
            }

            3 -> {
                println("Saliendo del programa")
            }

            else -> {
                println("¡Opción incorrecta!. Pulse INTRO para continuar")
                readLine()
            }
        }
    } while (opcion != 3)
}

fun limpiarPantalla() {
    val os = System.getProperty("os.name").lowercase()

    if (os.contains("win")) {
        ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
    } else {
        ProcessBuilder("clear").inheritIO().start().waitFor()
    }
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