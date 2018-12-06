import java.io.File

fun dayFiveFirstPuzzle(input: String): Int {
    val stack = mutableListOf<Char>()
    for (c in input) {
        if (stack.isNotEmpty() && c == reverseCase(stack.last())) {
            stack.removeAt(stack.lastIndex)
        } else {
            stack.add(c)
        }
    }
    return stack.size
}

fun dayFiveSecondPuzzle(input: String): Int {
    val charSet = input.toLowerCase().toSet()
    return charSet.map { c1: Char ->  dayFiveFirstPuzzle(input.filter { c2 -> c2.toLowerCase() != c1 }) }.min() ?: 0
}

fun reverseCase(c: Char): Char = if (c.isLowerCase()) c.toUpperCase() else c.toLowerCase()

fun main(args: Array<String>) {
    println(dayFiveSecondPuzzle(File("inputs/dayFive.txt").readText()))
}