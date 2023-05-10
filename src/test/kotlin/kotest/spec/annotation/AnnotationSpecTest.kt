package kotest.spec.annotation

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import kotest.spec.Calculator

internal class AnnotationSpecTest : AnnotationSpec() {

    private val sut = Calculator()

    @Test
    fun `1과 2를 더하면 3이다`() {
        val actual = sut.plus(1, 2)
        actual shouldBe 3
    }

    @Test
    fun `1과 2를 곱하면 2다`() {
        val actual = sut.mult(1, 2);
        actual shouldBe 2
    }

    @Test
    fun `입력값이 null이면 예외를 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            sut.mult(1, null);
        }
    }
}

