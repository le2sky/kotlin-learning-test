package nullsafety

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class NullSafetyTest : AnnotationSpec() {

    @Test
    fun `기본적으로 타입을 명시하면 non-null 타입이다`() {
        var neverNull: String = "this can't be null";
        // neverNull = null <- Null can not be a value of a non-null type String
    }

    @Test
    fun `nullable 하게 만들려면 ?를 타입 뒤에 추가한다`() {
        var nullable: String? = "can keep a null hear"
        nullable = null
    }

    @Test
    fun `기본적으로 컴파일러는 타입 추론을 할때 non-null로 인지한다`() {
        var inferredNonNull = "the compiler assumes non-null"
        // inferredNonNull = null <- Null can not be a value of a non-null type String
    }

    @Test
    fun `null 트래킹`() {
        fun describeString(maybeString: String?): String {
            if (maybeString != null) {
                return "${maybeString.length} 길이의 문자열"
            } else {
                return "null 문자열"
            }
        }

        val nullActual = describeString(null)
        val nonNullActual = describeString("le2sky")
        nullActual shouldBe "null 문자열"
        nonNullActual shouldBe "6 길이의 문자열"
    }
}