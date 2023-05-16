package scopefunction

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class AlsoTest : AnnotationSpec() {

    @Test
    fun `apply와 유사하지만, 람다 리시버를 받지 않는다`() {
        data class Person(var name: String, var age: Int, var about: String) {
            constructor() : this("", 0, "")
        }

        val jake = Person("jake", 30, "kotlin developer")
            .also {
                it.name = "Jake"
                it.about = "Kotlin developer"
            }
        jake.name shouldBe "Jake"
        jake.about shouldBe "Kotlin developer"
        jake.age shouldBe 30
    }
}