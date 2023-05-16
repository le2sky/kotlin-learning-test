package scopefunction

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class ApplyTest : AnnotationSpec() {

    @Test
    fun `apply는 run과 유사하지만 T를 반환함`() {
        data class Person(var name: String, var age: Int, var about: String) {
            constructor() : this("", 0, "")
        }

        val jake = Person()
        val applyJake = jake.apply {
            name = "Jake"
            age = 30
            about = "Kotlin developer"
        }

        jake shouldBe applyJake
        jake.age shouldBe 30
        jake.about shouldBe "Kotlin developer"
        jake.name shouldBe "Jake"
    }
}