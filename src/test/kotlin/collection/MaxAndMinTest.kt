package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

internal class MaxAndMinTest : AnnotationSpec() {

    val numbers = listOf(1, 2, 3)
    val empty = emptyList<Int>()
    val only = listOf(3)

    @Test
    fun `minOrNull - 최솟값 반환`() {
        val minOrNullWithNumbers = numbers.minOrNull()
        val minOrNullWithEmpty = empty.minOrNull()
        val minOrNullWithOnly = only.minOrNull()

        minOrNullWithNumbers shouldBe 1
        minOrNullWithEmpty.shouldBeNull()
        minOrNullWithOnly shouldBe 3
    }

    @Test
    fun `maxOrNull - 최댓값 반환`() {
        val maxOrNullWithNumbers = numbers.maxOrNull()
        val maxOrNullWithEmpty = empty.maxOrNull()
        val maxOrNullWithOnly = only.maxOrNull()

        maxOrNullWithNumbers shouldBe 3
        maxOrNullWithEmpty.shouldBeNull()
        maxOrNullWithOnly shouldBe 3
    }
}