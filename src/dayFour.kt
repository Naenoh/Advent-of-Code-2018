import java.io.File

fun dayFourPuzzleOne(inputs: List<String>): Int {
    val guardMap = generateGuardTimetables(inputs)

    val sleepiestGuard = guardMap.maxBy { entry -> entry.value.sum() }
    return if (sleepiestGuard != null) {
        sleepiestGuard.key * (indexOfMax(sleepiestGuard.value) ?: 0)
    } else {
        0
    }
}

fun dayFourPuzzleTwo(inputs: List<String>): Int {
    val guardMap = generateGuardTimetables(inputs)
    val sleepiestGuard = guardMap.maxBy { entry -> entry.value.max() ?: 0 }
    return if (sleepiestGuard != null) {
        sleepiestGuard.key * (indexOfMax(sleepiestGuard.value) ?: 0)
    } else {
        0
    }
}

fun main(args: Array<String>) {
    println(dayFourPuzzleTwo(File("inputs/dayFour.txt").readLines()))
}

fun sortLinesByDate(inputs: List<String>): List<String> = inputs.sorted()
fun extractId(line: String): Int = line.substringAfter("#").substringBefore(" ").toInt()
fun extractMin(line: String): Int = line.substringAfter(":").substringBefore("]").toInt()
fun indexOfMax(array: IntArray): Int? = array.withIndex().maxBy { it.value }?.index

fun generateGuardTimetables(inputs: List<String>): Map<Int, IntArray> {
    var currentGuard = 0
    var startSleep = -1
    val guardMap = HashMap<Int, IntArray>()
    for (line in sortLinesByDate(inputs)) {
        if (line.contains("begins shift")) {
            currentGuard = extractId(line)
            if (currentGuard !in guardMap) {
                guardMap[currentGuard] = IntArray(60)
            }
        } else if(line.contains("falls asleep")) {
            startSleep = extractMin(line)
        } else if(line.contains("wakes up")) {
            val guardTimetable = guardMap[currentGuard]
            for (i in startSleep until extractMin(line)) {
                guardTimetable!![i]++
            }
        }
    }
    return guardMap
}