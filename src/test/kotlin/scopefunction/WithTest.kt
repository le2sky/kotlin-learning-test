package scopefunction

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class WithTest : AnnotationSpec() {

    @Test
    fun `with는 non-extension 함수이며 객체를 직접 입력 받는다`() {
        data class Person(var name: String, var age: Int)

        val person = Person("lee", 23)
        // T.()를 람다 리시버라고 함
        with(person) {
            age++
            age++
        }
        person.age shouldBe 25
    }
}