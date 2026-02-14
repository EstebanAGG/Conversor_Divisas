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

fun actualizarTasas(tasasDeCambio: TablaTasas, nuevaTasa: Double, tablaActualizar: Divisas, divisaActualizarTasa: Divisas): TablaTasas {
    when (tablaActualizar) {
        Divisas.Dolares -> return tasasDeCambio.copy(
            tasasDeCambioUSD= tasasDeCambio.tasasDeCambioUSD.mapIndexed { index, tasa ->
                if (index == divisaActualizarTasa.ordinal) nuevaTasa
                else tasa
            }
        )
        Divisas.Euros -> return tasasDeCambio.copy(
            tasasDeCambioEUR = tasasDeCambio.tasasDeCambioEUR.mapIndexed { index, tasa ->
                if (index == divisaActualizarTasa.ordinal) nuevaTasa
                else tasa
            }
        )
        Divisas.Libras -> return tasasDeCambio.copy(
            tasasDeCambioGBP = tasasDeCambio.tasasDeCambioGBP.mapIndexed { index, tasa ->
                if (index == divisaActualizarTasa.ordinal) nuevaTasa
                else tasa
            }
        )
        else -> return tasasDeCambio.copy(
            tasasDeCambioJPY = tasasDeCambio.tasasDeCambioJPY.mapIndexed { index, tasa ->
                if (index == divisaActualizarTasa.ordinal) nuevaTasa
                else tasa
            }
        )
    }
}

