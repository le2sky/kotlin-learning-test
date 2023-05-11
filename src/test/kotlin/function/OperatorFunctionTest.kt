package function

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class OperatorFunctionTest : AnnotationSpec() {

    @Test
    fun `operator overloading - repeat string`() {
        operator fun Int.times(str: String) = str.repeat(this)
        val actual = 2 * "*"
        actual shouldBe "**"
    }

    @Test
    fun `operator overloading - 범위 문자열 추출`() {
        operator fun String.get(range: IntRange) = substring(range)
        val intRange = 0..2
        val actual = "leesky"[intRange]
        actual shouldBe "lee"
    }
}