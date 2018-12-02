import java.io.File

fun firstPuzzle(inputs: List<String>): Int {
    val (a, b) = inputs.fold(Pair(0,0)) {
        (a, b), s ->
        val (hasTwo, hasThree) = findRepetitions(s)
        return@fold Pair(a + if (hasTwo) 1 else 0, b + if (hasThree) 1 else 0)
    }
    return a * b
}

fun findRepetitions(id: String): Pair<Boolean, Boolean> {
    val freqList = countChars(id)
    return Pair(2 in freqList, 3 in freqList)
}

fun countChars(id: String): Set<Int> = id.groupBy { c: Char -> c }.values.map { it.size }.toSet()

fun secondPuzzle(inputs: List<String>): String {
    for ((index, s1) in inputs.withIndex()) {
        for (s2 in inputs.subList(index, inputs.lastIndex)) {
            if(findNumberOfDifferentLetters(s1, s2) == 1) {
                return extractCommonLetters(s1, s2)
            }
        }

    }
    return ""
}

fun findNumberOfDifferentLetters(s1: String, s2: String): Int {
    var cpt = 0
    s1.forEachIndexed { index, c ->  cpt += if (c == s2[index]) 0 else 1}
    return cpt
}

fun extractCommonLetters(s1: String, s2: String): String {
    return s1.filter { letter -> letter in s2 }
}

fun main(args: Array<String>) {
    println(secondPuzzle(File("inputs/dayTwoFirstPuzzle.txt").readLines()))
}