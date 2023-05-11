package generic

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

internal class GenericTest : AnnotationSpec() {

    @Test
    fun `generic class - mutable stack`() {
        val stack = MutableStack(1, 2, 3)
        stack.push(4)
        stack.size() shouldBe 4
        stack.isEmpty().shouldBeFalse()
        stack.pop()
        stack.size() shouldBe 3
        stack.peek() shouldBe 3
    }

    @Test
    fun `generic function - mutable stack of`() {
        fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)
        val mutableStackOf = mutableStackOf(0.1, 0.12, 3.14)
        mutableStackOf.pop() shouldBe 3.14
        mutableStackOf.pop().shouldBeTypeOf<Double>()
    }

    class MutableStack<E>(vararg items: E) {
        private val elements = items.toMutableList()

        fun push(element: E) = elements.add(element)
        fun peek(): E = elements.last()
        fun pop(): E = elements.removeAt(elements.size - 1)
        fun isEmpty() = elements.isEmpty()
        fun size() = elements.size

        override fun toString(): String {
            return "MutableStack(elements=$elements)"
        }
    }
}
