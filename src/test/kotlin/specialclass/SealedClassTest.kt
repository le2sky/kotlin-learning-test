package specialclass

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class SealedClassTest : AnnotationSpec() {

    sealed class Mammal(val name: String)
    class Cat(val catName: String) : Mammal(catName)
    class Human(val humanName: String, val job: String) : Mammal(humanName)

    @Test
    fun `sealed class는 상속을 제한할 수 있다(패키지 내부로)`() {
        fun greetMammal(mammal: Mammal): String {
            return when (mammal) {
                is Human -> "hello, ${mammal.name}, you're working as a ${mammal.job}"
                is Cat -> "hello, ${mammal.name}"
            }
        }

        val actual = greetMammal(Human("leesky", "student"))
        actual shouldBe "hello, leesky, you're working as a student"
    }
}