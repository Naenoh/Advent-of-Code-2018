import java.io.File
import kotlin.math.abs

data class Point(val x: Int, val y: Int)

fun daySixFirstPuzzle(inputs: List<String>): Int {
    val points = inputs.map { s ->
        val coords = s.split(", ").map { it.toInt() }
        Point(coords[0], coords[1])
    }
    val maxX = points.maxBy { point -> point.x }?.x ?: 0
    val maxY = points.maxBy { point -> point.y }?.y ?: 0
    val grid = Array(maxX + 1) { IntArray(maxY + 1) }
    val infinites = mutableSetOf(-1)
    for (i in 0 until maxX) {
        for (j in 0 until maxY) {
            val p2 = Point(i,j)
            val distances = points.map { p1 -> manhattanDistance(p1, p2) }
            val min = distances.withIndex().minBy { it.value }
            val indexOfClosestPoint: Int

            // If two points share the smallest distance
            indexOfClosestPoint = if (distances.count { it == min?.value ?: 0 } > 1) {
                -1
            } else {
                min?.index ?: 0
            }

            grid[i][j] = indexOfClosestPoint

            // If it touches the border, its infinite
            if (i == 0 || j == 0 || i == maxX || j == maxY) {
                infinites.add(indexOfClosestPoint)
            }
        }
    }
    val countMap = mutableMapOf<Int, Int>()
    for (row in grid) {
        val grouped = row.groupBy { it }
        for ((k, v) in grouped) {
            countMap[k] = v.size + countMap.getOrDefault(k, 0)
        }
    }
    return countMap.filter {
            entry -> entry.key !in infinites
    }.maxBy {
            entry -> entry.value
    }?.value ?: 0
}

fun daySixSecondPuzzle(inputs: List<String>, threshold: Int): Int {
    val points = inputs.map { s ->
        val coords = s.split(", ").map { it.toInt() }
        Point(coords[0], coords[1])
    }
    val maxX = points.maxBy { point -> point.x }?.x ?: 0
    val maxY = points.maxBy { point -> point.y }?.y ?: 0
    var cpt = 0
    for (i in 0 until maxX) {
        for (j in 0 until maxY) {
            val p2 = Point(i, j)
            val distances = points.map { p1 -> manhattanDistance(p1, p2) }
            if (distances.sum() < threshold) {
                cpt++
            }
        }
    }
    return cpt
}

fun manhattanDistance(p1: Point, p2: Point): Int = abs(p2.x - p1.x) + abs(p2.y - p1.y)

fun main(args: Array<String>) {
    println(daySixSecondPuzzle(File("inputs/daySix.txt").readLines(), 10000))
}