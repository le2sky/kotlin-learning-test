package controlflow

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class ConditionalExpressionTest : AnnotationSpec() {

    @Test
    fun `삼항 연산자가 없는 대신 if expression을 사용 가능하다`() {
        fun max(a: Int, b: Int) = if (a > b) a else b
        max(99, -42) shouldBe 99
    }
}