/**
 * Gestión de las tasas de cambio
 */
enum class Divisas {
    Dolares, Euros, Libras, Yenes
}

data class TablaTasas(
    val tasasDeCambioEUR: List<Double> = listOf(1.1867, 1.0, 0.8713, 181.46),
    val tasasDeCambioUSD: List<Double> = listOf(1.0, 0.8426, 0.7342, 152.90),
    val tasasDeCambioGBP: List<Double> = listOf(1.3620, 1.1478, 1.0, 208.23),
    val tasasDeCambioJPY: List<Double> = listOf(0.654022, 0.55118, 0.480227, 1.0)
)

fun actualizarTasas(tasasDeCambio: TablaTasas, nuevaTasa: Double,
                    tablaActualizar: Divisas, divisaActualizarTasa: Divisas): TablaTasas {
    when (tablaActualizar) {
        Divisas.Dolares -> return tasasDeCambio.copy(
            tasasDeCambioUSD= actualizarListaTasas(tasasDeCambio.tasasDeCambioUSD,
                divisaActualizarTasa.ordinal,
                nuevaTasa)
        )
        Divisas.Euros -> return tasasDeCambio.copy(
            tasasDeCambioEUR = actualizarListaTasas(tasasDeCambio.tasasDeCambioEUR,
                divisaActualizarTasa.ordinal,
                nuevaTasa)
        )
        Divisas.Libras -> return tasasDeCambio.copy(
            tasasDeCambioGBP = actualizarListaTasas(tasasDeCambio.tasasDeCambioGBP,
                divisaActualizarTasa.ordinal,
                nuevaTasa)
        )
        else -> return tasasDeCambio.copy(
            tasasDeCambioJPY = actualizarListaTasas(tasasDeCambio.tasasDeCambioJPY,
                divisaActualizarTasa.ordinal,
                nuevaTasa,)
        )
    }
}

private fun actualizarListaTasas(listaAModificar: List<Double>, indice: Int, nuevaTasa: Double): List<Double>{
    return listaAModificar.mapIndexed { index, tasa ->
        if (index == indice) nuevaTasa
        else tasa
    }
}

