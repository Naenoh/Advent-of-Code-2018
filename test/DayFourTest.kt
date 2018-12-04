import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.File

internal class DayFourTest {

    @Test
    fun dayFourPuzzleOne() {
        assertEquals(240, dayFourPuzzleOne(File("inputs/dayFourExample.txt").readLines()))
    }

    @Test
    fun dayFourPuzzleTwo() {
        assertEquals(4455, dayFourPuzzleTwo(File("inputs/dayFourExample.txt").readLines()))
    }

    @Test
    fun sortLinesByDate() {
        assertEquals(listOf("[1518-04-19 00:47] wakes up", "[1518-10-04 00:57] wakes up", "[1518-10-29 00:51] falls asleep"),
                sortLinesByDate(listOf("[1518-10-29 00:51] falls asleep", "[1518-10-04 00:57] wakes up", "[1518-04-19 00:47] wakes up")))
    }

    @Test
    fun extractId() {
        assertEquals(99, extractId("[1518-11-05 00:03] Guard #99 begins shift"))
    }

    @Test
    fun extractMin() {
        assertEquals(3, extractMin("[1518-11-05 00:03] Guard #99 begins shift"))
    }

    @Test
    fun indexOfMax() {
        assertEquals(2, indexOfMax(intArrayOf(4,0,5)))
    }

}