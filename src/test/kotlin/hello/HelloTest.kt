package hello

import io.kotest.core.spec.style.AnnotationSpec

internal class HelloTest : AnnotationSpec() {

    @Test
    fun `print hello world`() {
        println("hello, world")
    }
}