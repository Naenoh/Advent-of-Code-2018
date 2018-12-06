import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DayFiveTest {

    @Test
    fun dayFiveFirstPuzzle() {
        assertEquals(10, dayFiveFirstPuzzle("dabAcCaCBAcCcaDA"))
    }

    @Test
    fun dayFiveSecondPuzzle() {
        assertEquals(4, dayFiveSecondPuzzle("dabAcCaCBAcCcaDA"))
    }

    @Test
    fun reverseCase() {
        assertEquals('a', reverseCase('A'))
        assertEquals('A', reverseCase('a'))
    }
}