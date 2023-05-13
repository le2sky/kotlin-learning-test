package controlflow

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeTrue

internal class RangeTest : AnnotationSpec() {

    @Test
    fun `0부터 3까지 반복`() {
        for (i in 0..3) {
            println(i)
        }
    }

    @Test
    fun `0부터 2까지 반복`() {
        for (i in 0 until 3) {
            println(i)
        }
    }

    @Test
    fun `2부터 8까지 2씩 증가`() {
        for (i in 2..8 step 2) {
            println(i)
        }
    }

    @Test
    fun `3부터 0까지 반복`() {
        for (i in 3 downTo 0) {
            println(i)
        }
    }

    @Test
    fun `char range 지원 - a부터 d까지 반복`() {
        for (c in 'a'..'d') {
            println(c)
        }
    }

    @Test
    fun `char range 지원 - z부터 s까지 2씩 감소`() {
        for (c in 'z' downTo 's' step 2) {
            println(c)
        }
    }

    @Test
    fun `range expression - x가 1과 5 사이의 수인가?(if에서 사용 가능)`() {
        val x = 2
        val actual = x in 1..5
        actual.shouldBeTrue()
    }

    @Test
    fun `range expression - x가 6과 10 사이에 포함되지 않는 수인가?`() {
        val x = 2
        val actual = x !in 6..10
        actual.shouldBeTrue()
    }
}
