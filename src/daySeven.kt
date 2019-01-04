import java.io.File

fun daySevenFirstPuzzle(inputs: List<String>): String {
    val map = mutableMapOf<String, MutableList<String>>()
    var res = ""
    for (input in inputs) {
        val regex = "Step ([A-Z]) must be finished before step ([A-Z]) can begin.".toRegex()
        val matchResult = regex.find(input)
        val (first, second) = matchResult!!.destructured
        map.putIfAbsent(first, mutableListOf())
        map.putIfAbsent(second, mutableListOf())
        map[second]?.add(first)
    }
    while (map.isNotEmpty()) {
        val next = map.filter { it.value.size == 0 }.minBy { it.key }?.key
        res += next
        map.remove(next)
        for (entry in map) {
            entry.value.remove(next)
        }
    }
    return res
}

fun daySevenSecondPuzzle(inputs: List<String>): String {
    return ""
}

fun main(args: Array<String>) {
    println(daySevenFirstPuzzle(File("inputs/daySeven.txt").readLines()))
}