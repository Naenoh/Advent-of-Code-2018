import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DayThreeTest {

    @Test
    fun dayThreePuzzleOne() {
        assertEquals(4, dayThreePuzzleOne(listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
    }

    @Test
    fun dayThreePuzzleTwo() {
        assertEquals(3, dayThreePuzzleTwo(listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
    }
    @Test
    fun parseClaim() {
        val claim = Claim("#1 @ 1,3: 4x4")
        assertEquals(1, claim.id)
        assertEquals(2, claim.startX)
        assertEquals(5, claim.endX)
        assertEquals(4, claim.startY)
        assertEquals(7, claim.endY)
    }

    @Test
    fun claimOverlap() {
        val claim1 = Claim("#1 @ 1,3: 4x4")
        val claim2 = Claim("#2 @ 3,1: 4x4")
        val claim3 = Claim("#3 @ 5,5: 2x2")
        assertTrue(claim1.overlapsWith(claim2))
        assertTrue(claim2.overlapsWith(claim1))
        assertFalse(claim1.overlapsWith(claim3))
        assertFalse(claim3.overlapsWith(claim2))
        assertTrue(claim1.overlapsWith(claim1))
    }
}