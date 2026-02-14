/**
 * Gestión de las tasas de cambio
 */
enum class Divisas {
    Dolares, Euros, Libras, Yenes
}
val tasasDeCambioEUR: List<Double> = listOf(1.1867,1.0,0.8713,181.46)

val tasasDeCambioUSD: List<Double> = listOf(1.0,0.8426,0.7342,152.90)

val tasasDeCambioGBP: List<Double> = listOf(1.3620,1.1478,1.0,208.23)

val tasasDeCambioJPY: List<Double> = listOf(0.654022,0.55118,0.480227,1.0)

fun actualizarTasas(tasasDeCambio: List<Double>, nuevaTasa: Double, divisaActualizarTasa: Divisas): List<Double>
{
    val nuevaListaDeTasas = tasasDeCambio.mapIndexed { index, tasa ->
        if (index == divisaActualizarTasa.ordinal) nuevaTasa
        else tasa
    }
    return nuevaListaDeTasas
}

