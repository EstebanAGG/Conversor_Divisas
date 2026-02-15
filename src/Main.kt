import entradaSalida.esperarIntro
import entradaSalida.imprimeResultado
import entradaSalida.leerDivisa
import entradaSalida.leerValor
import entradaSalida.limpiarPantalla
import entradaSalida.menu

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
        opcion = menu()
        when (opcion) {
            1 -> {
                val monto = leerValor("Introduce el monto: ")
                if (monto > -1) {
                    val divisaOrigen = leerDivisa("Selecciona divisa origen: ")
                    val divisaDestino = leerDivisa("Selecciona divisa destino: ")
                    val conversion = convertirMonto(
                        tablaDeTasasAplicable, monto, Divisas.entries[divisaOrigen],
                        Divisas.entries[divisaDestino]
                    )
                    imprimeResultado(monto, divisaOrigen, conversion, divisaDestino)
                }
            }
            2 -> {
                limpiarPantalla()
                val nuevaTasa = leerValor("Introduce la nueva tasa: ")
                if (nuevaTasa > -1) {
                    val tablaDivisas = leerDivisa("Selecciona la tabla de divisas a modificar: ")
                    val divisaModificada = leerDivisa("Selecciona la divisa a modificar la tasa: ")
                    tablaDeTasasAplicable = actualizarTasas(tablaDeTasasAplicable,
                        nuevaTasa,
                        Divisas.entries.get(tablaDivisas),
                        Divisas.entries.get(divisaModificada))
                }else{
                    esperarIntro("Tasa incorrecta! - Pulsa INTRO para continuar.")
                }
            }

            3 -> {
                esperarIntro("Saliendo del programa - Pulse INTRO para terminar.")
            }

            else -> {
                esperarIntro("¡Opción incorrecta! - Pulse INTRO para continuar.")
            }
        }
    } while (opcion != 3)
}