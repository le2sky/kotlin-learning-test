package functional

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class HigherOrderFunctionTest : AnnotationSpec() {

    @Test
    fun `고차 함수는 다른 함수를 파라미터로 받거나 반환할 수 있는 함수`() {
        fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
            return operation(x, y)
        }

        fun sum(x: Int, y: Int) = x + y

        // ::은 코틀린에서 이름으로 함수를 참조하는 표기법이다
        calculate(2, 3, ::sum) shouldBe 5
        // lambda를 함수 인자로 전달
        calculate(5, 2) { a, b -> a * b } shouldBe 10
    }

    @Test
    fun `function을 리턴한다`() {
        fun square(i: Int): Int {
            return i * i
        }

        fun operation(): (Int) -> Int {
            return ::square
        }

        val actual = operation()
        actual(2) shouldBe 4
    }
}