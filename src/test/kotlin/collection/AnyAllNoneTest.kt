package collection

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

internal class AnyAllNoneTest : AnnotationSpec() {

    @Test
    fun `any - 하나라도 성공하면 true`() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val actual = numbers.any { it < 0 }
        actual.shouldBeTrue()
    }

    @Test
    fun `all - 모두 성공하면 true`() {
        val numbers = listOf(1, -2, 3, -4, 5, 6)
        (numbers.all { it % 2 == 0 }).shouldBeFalse()
        (numbers.all { it != 0 }).shouldBeTrue()
    }

    @Test
    fun `none - 모두 실패하면 true`() {
        val numbers = listOf(1, 2, 3)
        (numbers.none { it < 0 }).shouldBeTrue()
    }
}