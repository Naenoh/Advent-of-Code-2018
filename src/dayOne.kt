import java.io.File

fun firstPuzzle(freqs: Array<Int>) = freqs.sum()

fun secondPuzzle(freqs: Array<Int>): Int {
    var currentFreq = 0
    val freqReachedList: MutableList<Int> = mutableListOf()
    var i = 0
    while (currentFreq !in freqReachedList) {
        freqReachedList.add(currentFreq)
        currentFreq += freqs[i]
        i++
        if (i == freqs.size) {
            i = 0
        }
    }
    return currentFreq
}

fun main(args: Array<String>) {
    val file = File("inputs/dayOneFirstPuzzle.txt")
    val numberArray = file.readLines().map(String::toInt).toTypedArray()
    println(secondPuzzle(numberArray)) // 430
}