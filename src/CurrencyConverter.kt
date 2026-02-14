/**
 * Funciones específicas del proceso de conversión
 */

fun convertirMonto(monto: Double, monedaOrigen: Divisas, monedaDestino: Divisas): Double {
    when (monedaOrigen) {
        Divisas.Euros -> return convertirEuros(monto, monedaDestino)
        Divisas.Dolares -> return convertirDolares(monto, monedaDestino)
        Divisas.Libras -> return convertirLibras(monto, monedaDestino)
        Divisas.Yenes -> return convertirYenes(monto, monedaDestino)
        else -> return -1.0
    }
}

fun convertirEuros(monto: Double, monedaDestino: Divisas): Double {
    return monto * tasasDeCambioEUR[monedaDestino.ordinal]
}

fun convertirDolares(monto: Double, monedaOrigen: Divisas): Double {
    return monto * tasasDeCambioUSD[monedaOrigen.ordinal]
}

fun convertirLibras(monto: Double, monedaDestino: Divisas): Double {
    return monto * tasasDeCambioGBP[monedaDestino.ordinal]
}

fun convertirYenes(monto: Double, monedaDestino: Divisas): Double {
    return monto * tasasDeCambioJPY[monedaDestino.ordinal]
}