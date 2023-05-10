package kotest.spec

class Calculator {

    fun plus(a: Int, b: Int) = a + b;
    fun mult(a: Int, b: Int?) = a * (b ?: throw IllegalArgumentException());
}