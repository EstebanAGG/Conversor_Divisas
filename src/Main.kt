/**
 * Punto de entrada de la aplicación
 */

fun main() {
//    val eurUsd = convertirMonto(100.0,Divisas.Euros,Divisas.Dolares)
//    println("${Divisas.Euros.ordinal} , ${Divisas.Dolares.ordinal}")
//    println("100 Euros: %.2f dolares".format(eurUsd))
    var opcion: Int

    do{
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
                if (monto > -1){
                    do {
                        Divisas.entries.mapIndexed { index, divisa -> println("$index -- $divisa") }
                        print("Selecciona divisa origen: ")
                        val divisaOrigen = readLine()?.toIntOrNull() ?: -1
                        if (divisaOrigen in Divisas.entries.indices) {
                            do{
                                Divisas.entries.mapIndexed { index, divisa -> println("$index -- $divisa") }
                                print("Selecciona divisa destino: ")
                                val divisaDestino = readLine()?.toIntOrNull() ?: -1
                                if (divisaDestino in Divisas.entries.indices) {
                                    val conversion = convertirMonto(monto,Divisas.entries[divisaOrigen],
                                        Divisas.entries[divisaDestino])
                                    println("$monto ${Divisas.entries[divisaOrigen]} = " +
                                            "%.2f ${Divisas.entries[divisaDestino]}".format(conversion))
                                }else{
                                    println("Selección incorrecta. Pulse INTRO para continuar.")
                                    readLine()
                                }
                            }while (divisaDestino !in Divisas.entries.indices)
                        } else {
                            println("Selección incorrecta. Pulse INTRO para continuar.")
                            readLine()
                        }
                    }while (divisaOrigen !in Divisas.entries.indices)
                }else{
                    println("Valor incorrecto. Pulsa INTRO para continuar.")
                    readLine()
                }
            }
            2 -> {

            }
            3 -> {
                println("Saliendo del programa")
            }
            else -> {
                println("¡Opción incorrecta!. Pulse INTRO para continuar")
                readLine()
            }
        }
    }while(opcion != 3)
}

fun limpiarPantalla() {
    val os = System.getProperty("os.name").lowercase()

    if (os.contains("win")) {
        ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
    } else {
        ProcessBuilder("clear").inheritIO().start().waitFor()
    }
}