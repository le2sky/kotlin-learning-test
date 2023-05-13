package controlflow

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

internal class EqualityCheckTest : AnnotationSpec() {

    @Test
    fun `코틀린에서 == 연산자는 구조적 비교를 한다`() {
        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")
        (authors == writers).shouldBeTrue()
    }

    @Test
    fun `코틀린에서 === 연산자는 참조 비교를 한다`() {
        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")
        (authors === writers).shouldBeFalse()
    }
}