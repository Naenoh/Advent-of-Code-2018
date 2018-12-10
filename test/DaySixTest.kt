import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class DaySixTest {

    @Test
    fun daySixFirstPuzzle() {
        assertEquals(17, daySixFirstPuzzle(File("inputs/daySixExample.txt").readLines()))
    }

    @Test
    fun daySixSecondPuzzle() {
        assertEquals(16, daySixSecondPuzzle(File("inputs/daySixExample.txt").readLines(), 32))
    }

    @Test
    fun manhattanDistance() {
        assertEquals(0, manhattanDistance(Point(1,1), Point(1,1)))
        assertEquals(3, manhattanDistance(Point(2,2), Point(4,3)))
        assertEquals(2, manhattanDistance(Point(2,1), Point(0,1)))
    }
}