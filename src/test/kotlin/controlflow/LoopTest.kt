package controlflow

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class LoopTest : AnnotationSpec() {

    @Test
    fun `for test`() {
        val cakes = listOf("carrot", "cheese", "chocolate")
        for (cake in cakes) {
            println("cake = ${cake}")
        }
    }

    @Test
    fun `while and do while test`() {
        fun eatACake() = println("Eat a Cake")
        fun bakeACake() = println("Bake a Cake")
        var cakesEaten = 0
        var cakesBaked = 0

        while (cakesEaten < 5) {
            eatACake()
            cakesEaten++
        }

        do {
            bakeACake()
            cakesBaked++
        } while (cakesBaked < cakesEaten)

        cakesEaten shouldBe 5
        cakesBaked shouldBe 5
    }

    // 이터레이터는 타입이나 확장 함수로 선언할 수 있다.
    @Test
    fun `iterator test - user defined iterator`() {
        class Animal(val name: String)
        class Zoo(val animals: List<Animal>) {
            operator fun iterator(): Iterator<Animal> {
                return animals.iterator()
            }
        }

        val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
        for (animal in zoo) {
            println(animal.name)
        }
    }
}