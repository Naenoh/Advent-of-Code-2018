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

class Claim(input: String) {
    val id = input.split(" ")[0].removePrefix("#").toInt()
    val startX = input.split(" ")[2].split(",")[0].toInt() + 1
    val startY = input.split(" ")[2].split(",")[1].removeSuffix(":").toInt() + 1
    val endX = startX + input.split(" ")[3].split("x")[0].toInt() - 1
    val endY = startY + input.split(" ")[3].split("x")[1].toInt() - 1
    
    fun overlapsWith(otherClaim: Claim): Boolean {
        return !((startX > otherClaim.endX || otherClaim.startX > endX)
                || (startY > otherClaim.endY || otherClaim.startY > endY))

    }
}

fun main(args: Array<String>) {
    println(dayThreePuzzleTwo(File("inputs/dayThreeFirstPuzzle.txt").readLines()))
}