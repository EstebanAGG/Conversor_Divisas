/**
 * Funciones específicas del proceso de conversión
 */

fun convertirMonto(tablaDeTasas: TablaTasas, monto: Double, monedaOrigen: Divisas, monedaDestino: Divisas): Double {
    when (monedaOrigen) {
        Divisas.Euros -> return convertir(tablaDeTasas.tasasDeCambioEUR, monto, monedaDestino)
        Divisas.Dolares -> return convertir(tablaDeTasas.tasasDeCambioUSD, monto, monedaDestino)
        Divisas.Libras -> return convertir(tablaDeTasas.tasasDeCambioGBP,monto, monedaDestino)
        else -> return convertir(tablaDeTasas.tasasDeCambioJPY,monto, monedaDestino)
    }
}

fun convertir(listaTasas: List<Double>, monto: Double, monedaDestino: Divisas): Double {
    return monto * listaTasas[monedaDestino.ordinal]
}