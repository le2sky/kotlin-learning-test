package kotest.spec.behavior

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotest.spec.Calculator

internal class BehaviorSpecTest : BehaviorSpec({
    val sut = Calculator()
    given("calculate") {
        val a = 1
        val b = 2

        `when`("1 더하기 2는") {
            val actual = sut.plus(a, b)
            then("3이다") {
                actual shouldBe 3
            }
        }

        `when`("1 곱하기 2는") {
            val actual = sut.mult(a, b)
            then("2다") {
                actual shouldBe 2
            }
        }

        `when`("null 값이 입력된 경우") {
            then("예외를 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    sut.mult(a, null)
                }
            }
        }
    }
})