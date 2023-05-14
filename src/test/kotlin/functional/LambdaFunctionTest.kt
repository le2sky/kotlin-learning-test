package functional

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class LambdaFunctionTest : AnnotationSpec() {

    @Test
    fun `lambda functions are simple way to create functions ad-hoc`() {
        // 타입 추론 가능
        val upperCase1: (String) -> String = { str: String -> str.uppercase() }
        val upperCase2: (String) -> String = { str -> str.uppercase() }
        val upperCase3 = { str: String -> str.uppercase() }
        // 타입 추론 힘듦
        // val upperCase4 = { str -> str.uppercase() }

        // 매개변수가 하나인 경우, 암시적 변수 it 사용 가능
        val upperCase5: (String) -> String = { it.uppercase() }

        // 단일 호출일 경우, 함수 포인터 사용 가능
        val upperCase6: (String) -> String = String::uppercase
        val expected = "HELLO"
        upperCase1("hello") shouldBe expected
        upperCase2("hello") shouldBe expected
        upperCase3("hello") shouldBe expected
        upperCase5("hello") shouldBe expected
        upperCase6("hello") shouldBe expected
    }
}