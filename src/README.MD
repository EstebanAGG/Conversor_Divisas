# Simulador de divisas
 * Convertir montos entre distintas monedas utilizando tasas de cambio que puedan actualizarse dinámicamente.
 * Implementar el simulador utilizando programación funcional, asegurando la aplicación de conceptos como funciones puras, composición de funciones, inmutabilidad y listas inmutables.
 * Utilizar funciones de orden superior para mejorar la reutilización y escalabilidad del código.
 * Dividir la aplicación de manera lógica en múltiples archivos para mantener un código organizado y fácil de evaluar.
 * Proveer un conjunto de tasas de cambio predefinido y permitir que el usuario actualice estas tasas dentro del programa sin afectar la inmutabilidad de las conversiones anteriores.

## Mejoras
* Sugerencia	./src/Main.kt	(Mejora extra) Podrías añadir algunas comprobaciones o mensajes más claros cuando la divisa origen y destino sean la misma, aunque la lógica actual ya devuelve el monto correctamente gracias a la diagonal de la tabla de tasas.
* Sugerencia	./src/ExchangeRates.kt	(Mejora extra) Incluir comentarios o pruebas automatizadas que documenten el significado de cada índice en las listas de tasas (orden de Divisas) ayudaría a evitar incoherencias futuras si se modifica el enum.
* Sugerencia	./src/CurrencyConverter.kt	(Mejora extra) Podrías hacer explícita una función de orden superior como aplicarTasa que reciba el selector y devuelva una función de conversión parcial, fomentando aún más la composición y reutilización (por ejemplo: fun aplicarTasa(selector: (TablaTasas, Divisas) -> List<Double>): (TablaTasas, Double, Divisas, Divisas) -> Double = { tabla, monto, origen, destino -> convertir(selector(tabla, origen), monto, destino) }). 
* Sugerencia	./src/Main.kt	(Mejora extra) Podrías reducir la lógica imperativa en main componiendo pequeñas funciones puras que transformen entradas en resultados, dejando a main solo la orquestación de lectura/escritura y composición, reforzando el estilo funcional.