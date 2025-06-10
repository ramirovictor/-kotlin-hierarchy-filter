package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName


class FilterTest {

    @DisplayName("Filtra nós que não são múltiplos de 3")
    @Test
    fun testFilter() {
        val unfiltered: Hierarchy = ArrayBasedHierarchy(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
            intArrayOf(0, 1, 2, 3, 1, 0, 1, 0, 1, 1, 2)
        )
        val filteredActual: Hierarchy = unfiltered.filter { nodeId -> nodeId % 3 != 0 }
        val filteredExpected: Hierarchy = ArrayBasedHierarchy(
            intArrayOf(1, 2, 5, 8, 10, 11),
            intArrayOf(0, 1, 1, 0, 1, 2)
        )
        assertEquals(filteredExpected.formatString(), filteredActual.formatString())
    }

    @DisplayName("Aceita todos os nós")
    @Test
    fun testAllNodesAccepted() {
        val hierarchy = ArrayBasedHierarchy(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 1, 2)
        )
        val result = hierarchy.filter { true }

        val expected = ArrayBasedHierarchy(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 1, 2)
        )

        assertEquals(expected.formatString(), result.formatString())
    }

    @DisplayName("Rejeita todos os nós")
    @Test
    fun testNoNodesAccepted() {
        val hierarchy = ArrayBasedHierarchy(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 1, 2)
        )
        val result = hierarchy.filter { false }

        val expected = ArrayBasedHierarchy(
            intArrayOf(),
            intArrayOf()
        )

        assertEquals(expected.formatString(), result.formatString())
    }

    @DisplayName("Rejeita ancestral e remove descendentes")
    @Test
    fun testRejectParentRemovesChildren() {
        val hierarchy = ArrayBasedHierarchy(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(0, 1, 2, 1)
        )
        val result = hierarchy.filter { it != 2 }

        val expected = ArrayBasedHierarchy(
            intArrayOf(1, 4),
            intArrayOf(0, 1)
        )

        assertEquals(expected.formatString(), result.formatString())
    }

    @DisplayName("Filtra corretamente floresta com múltiplas raízes")
    @Test
    fun testMultipleRoots() {
        val hierarchy = ArrayBasedHierarchy(
            intArrayOf(10, 11, 12, 20, 21, 22),
            intArrayOf(0, 1, 2, 0, 1, 2)
        )
        val result = hierarchy.filter { it < 20 }

        val expected = ArrayBasedHierarchy(
            intArrayOf(10, 11, 12),
            intArrayOf(0, 1, 2)
        )

        assertEquals(expected.formatString(), result.formatString())
    }


}