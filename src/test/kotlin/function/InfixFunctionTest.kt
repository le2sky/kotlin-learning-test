package function

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

internal class InfixFunctionTest : AnnotationSpec() {

    @Test
    fun `단일 매개변수를 가지는 멤버 함수는 중위 함수로 변환 가능`() {
        val sophia = Person("Sophia")
        val claudia = Person("Claudia")
        sophia likes claudia
        sophia.likedPeople shouldContain claudia
    }

    @Test
    fun `단일 매개변수를 가지는 확장 함수는 중위 함수로 변환 가능`() {
        infix fun String.onto(other: String) = Pair(this, other)
        infix fun Int.times(str: String) = str.repeat(this)

        val times = 2 times "*"
        val myPair = "McLaren" onto "Lucas"
        val pair = "Ferrari" to "Katrina"

        myPair shouldBe Pair("McLaren", "Lucas")
        pair shouldBe Pair("Ferrari", "Katrina")
        times shouldBe "**"
    }

    class Person(val name: String) {
        val likedPeople = mutableListOf<Person>()
        infix fun likes(other: Person) {
            likedPeople.add(other)
        }
    }
}
