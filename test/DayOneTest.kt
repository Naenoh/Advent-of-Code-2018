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
}