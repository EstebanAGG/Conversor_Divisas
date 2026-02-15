/**
 * Funciones específicas del proceso de conversión
 */

//fun aplicarTasa(selector: (TablaTasas) -> List<Double>):(List<Double>, Double, Divisas) -> Double{
//    convertir(selector(tablaTasas), monto, monedaDestino)
//}

val selector: (TablaTasas,Divisas) -> List<Double> = { tablaTasas, divisaOrigen ->
    when (divisaOrigen){
        Divisas.Euros -> tablaTasas.tasasDeCambioEUR
        Divisas.Dolares -> tablaTasas.tasasDeCambioUSD
        Divisas.Libras -> tablaTasas.tasasDeCambioGBP
        else -> tablaTasas.tasasDeCambioJPY
    }

}

fun convertirMonto(tablaDeTasas: TablaTasas, monto: Double, monedaOrigen: Divisas, monedaDestino: Divisas): Double {
    return convertir(selector(tablaDeTasas,monedaOrigen), monto, monedaDestino)
}

fun convertir(listaTasas: List<Double>, monto: Double, monedaDestino: Divisas): Double {
    return monto * listaTasas[monedaDestino.ordinal]
}