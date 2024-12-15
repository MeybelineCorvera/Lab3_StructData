//MEYBELINE ABIGAIL CORVERA CRUZ

import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println("Seleccione una opcion:")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un numero")
        println("4. Resolver las Torres de Hanoi")
        println("5. Salir")

        when (readln().toIntOrNull()) {
            1 -> bubbleSortOption()
            2 -> quickSortOption()
            3 -> factorialOption()
            4 -> hanoiOption()
            5 -> {
                println("Saliendo del programa.")
                break
            }
            else -> println("Opcion invalida. Por favor intente de nuevo.")
        }
    }
}
 //Ordenar una lista usando Bubble Sort
fun bubbleSortOption() {
    println("Ingrese una lista de numeros separados por comas:")
    val input = readln()
    val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }

    val time = measureTimeMillis {
        val sortedList = bubbleSort(numbers)
        println("Lista ordenada usando Bubble Sort: $sortedList")
    }
    println("Tiempo de ejecucion: ${time / 1000.0} segundos")
}

// Ordenar una lista usando Quick Sort
fun quickSortOption() {
    println("Ingrese una lista de numeros separados por comas:")
    val input = readln()
    val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }

    val time = measureTimeMillis {
        val sortedList = quickSort(numbers)
        println("Lista ordenada usando Quick Sort: $sortedList")
    }
    println("Tiempo de ejecucion: ${time / 1000.0} segundos")
}

//Calcular el factorial de un número
fun factorialOption() {
    println("Ingrese un numero entero positivo:")
    val number = readln().toIntOrNull()
    if (number == null || number < 0) {
        println("Por favor ingrese un numero entero positivo valido.")
        return
    }

    val result = factorial(number)
    println("El factorial de $number es: $result")
}

// Resolver las Torres de Hanói
fun hanoiOption() {
    println("Ingrese el numero de discos:")
    val disks = readln().toIntOrNull()
    if (disks == null || disks <= 0) {
        println("Por favor ingrese un numero entero positivo valido.")
        return
    }

    println("Resolviendo las Torres de Hanoi para $disks discos:")
    solveHanoi(disks, 'A', 'C', 'B')
}

fun bubbleSort(numbers: List<Int>): List<Int> {
    val list = numbers.toMutableList()
    for (i in 0 until list.size - 1) {
        for (j in 0 until list.size - 1 - i) {
            if (list[j] > list[j + 1]) {
                val temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp
            }
        }
    }
    return list
}

fun quickSort(numbers: List<Int>): List<Int> {
    if (numbers.size <= 1) return numbers
    val pivot = numbers[numbers.size / 2]
    val less = numbers.filter { it < pivot }
    val equal = numbers.filter { it == pivot }
    val greater = numbers.filter { it > pivot }
    return quickSort(less) + equal + quickSort(greater)
}

fun factorial(n: Int): Long {
    return if (n == 0) 1 else n * factorial(n - 1)
}

fun solveHanoi(n: Int, from: Char, to: Char, aux: Char) {
    if (n == 1) {
        println("Mover disco 1 de Torre $from a Torre $to")
        return
    }
    solveHanoi(n - 1, from, aux, to)
    println("Mover disco $n de Torre $from a Torre $to")
    solveHanoi(n - 1, aux, to, from)
}
