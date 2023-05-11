package kotest.spec.describe

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotest.spec.Calculator

internal class DescribeSpecTest : DescribeSpec({
    val sut = Calculator()

    describe("calculate") {
        context("피연산자 a와 b가 주어지고") {
            val a = 1
            val b = 2
            it("더하면 3이다") {
                val actual = sut.plus(a, b)
                actual shouldBe 3
            }

            it("곱하면 2다") {
                val actual = sut.mult(a, b)
                actual shouldBe 2
            }
        }

        context("피연산자 b가 null로 주어지고") {
            val a = 1
            val b = null
            it("두 수를 곱하면 예외를 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    sut.mult(a, b)
                }
            }

        }
    }
})