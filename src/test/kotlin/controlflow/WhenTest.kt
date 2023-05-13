package controlflow

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class WhenTest : AnnotationSpec() {

    @Test
    fun `switch 대신 when을 사용한다`() {
        fun cases(obj: Any): String {
            when (obj) {
                1 -> return "One"
                "Hello" -> return "Greeting"
                is Long -> return "Long"
                !is String -> return "Not a string"
                else -> return "Unknown"
            }
        }
        cases("Hello") shouldBe "Greeting"
        cases(1) shouldBe "One"
        cases(1L) shouldBe "Long"
        cases(2) shouldBe "Not a string"
    }

    @Test
    fun `when을 expression처럼 다룬다 defalut (브랜치는 필수)`() {
        val obj = 1
        val actual = when (obj) {
            1 -> "one"
            else -> 42
        }
        actual shouldBe "one"
    }
}