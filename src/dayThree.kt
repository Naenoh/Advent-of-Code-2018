import java.io.File

fun dayThreePuzzleOne(inputs: List<String>): Int {
    val claims = inputs.map { Claim(it) }
    val fabric = Array(1000) { IntArray(1000) }
    for (claim in claims) {
        for (i in claim.startX..claim.endX) {
            for (j in claim.startY..claim.endY) {
                fabric[i][j]++
            }
        }
    }
    var result = 0
    for (row in fabric) {
        result += row.count { it > 1 }
    }
    return result
}

fun dayThreePuzzleTwo(inputs: List<String>): Int {
    val claims = inputs.map { Claim(it) }
    for (claim in claims) {
        if(claims.count { it.overlapsWith(claim) } == 1) {
            return claim.id
        }
    }
    return 0
}

class Claim(var id: Int, var startX: Int, var startY: Int, var endX: Int, var endY: Int) {

    constructor(input: String) : this(0, 0, 0, 0, 0) {
        val regex = "#([0-9]*) @ ([0-9]*),([0-9]*): ([0-9]*)x([0-9]*)".toRegex()
        val groups = regex.matchEntire(input)!!.groupValues.drop(1).map(String::toInt)
        this.id = groups[0]
        this.startX = groups[1] + 1
        this.startY = groups[2] + 1
        this.endX = groups[1] + groups[3]
        this.endY = groups[2] + groups[4]
    }

    fun overlapsWith(otherClaim: Claim): Boolean {
        return !((startX > otherClaim.endX || otherClaim.startX > endX)
                || (startY > otherClaim.endY || otherClaim.startY > endY))

    }
}

fun main(args: Array<String>) {
    println(dayThreePuzzleTwo(File("inputs/dayThreeFirstPuzzle.txt").readLines()))
}