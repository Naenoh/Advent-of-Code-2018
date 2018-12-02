import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DayTwoTest {

    @Test
    fun firstPuzzle() {
        assertEquals(12, firstPuzzle(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")))
    }

    @Test
    fun findRepetitions() {
        assertEquals(Pair(false, false), findRepetitions("abcdef"))
        assertEquals(Pair(true, true), findRepetitions("bababc"))
        assertEquals(Pair(true, false), findRepetitions("abbcde"))
        assertEquals(Pair(false, true), findRepetitions("abcccd"))
        assertEquals(Pair(true, false), findRepetitions("aabcdd"))
        assertEquals(Pair(true, false), findRepetitions("abcdee"))
        assertEquals(Pair(false, true), findRepetitions("ababab"))
    }

    @Test
    fun countChars() {
        assertEquals(setOf(1, 2), countChars("bab"))
    }

    @Test
    fun secondPuzzle() {
        assertEquals("fgij", secondPuzzle(listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")))
    }

    @Test
    fun findNumberOfDifferentLetters() {
        assertEquals(1, findNumberOfDifferentLetters("abcde", "abcdf"))
        assertEquals(2, findNumberOfDifferentLetters("abcde", "aecdf"))
        assertEquals(5, findNumberOfDifferentLetters("abcde", "fghij"))
        assertEquals(0, findNumberOfDifferentLetters("abcde", "abcde"))
    }

    @Test
    fun extractCommonLetters() {
        assertEquals("fgij", extractCommonLetters("fghij", "fguij"))
    }
}