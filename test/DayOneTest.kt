import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DayOneTest {

    @Test
    fun firstPuzzle() {
        assertEquals(3, firstPuzzle(arrayOf(1, -2, 3, 1)))
        assertEquals(3, firstPuzzle(arrayOf(1, 1, 1)))
        assertEquals(0, firstPuzzle(arrayOf(1, 1, -2)))
        assertEquals(-6, firstPuzzle(arrayOf(-1, -2, -3)))
    }

    @Test
    fun secondPuzzle() {
        assertEquals(2, secondPuzzle(arrayOf(1, -2, 3, 1)))
        assertEquals(0, secondPuzzle(arrayOf(1, -1)))
        assertEquals(10, secondPuzzle(arrayOf(3, 3, 4, -2, -4)))
        assertEquals(5, secondPuzzle(arrayOf(-6, 3, 8, 5, -6)))
        assertEquals(14, secondPuzzle(arrayOf(7, 7, -2, -7, -4)))
    }
}