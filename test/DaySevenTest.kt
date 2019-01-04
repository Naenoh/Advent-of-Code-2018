import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class DaySevenTest {

    @Test
    fun daySevenFirstPuzzle() {
        assertEquals("CABDFE", daySevenFirstPuzzle(File("inputs/daySevenExample.txt").readLines()))
    }

    @Test
    fun daySevenSecondPuzzle() {
    }
}