fun main() {
    fun List<Int>.countValueIncreases() = fold(Pair<Int?, Int>(null, 0)) { (previousNumber, count), value ->
        Pair(value, count + if (previousNumber != null && previousNumber < value) 1 else 0)
    }.second

    fun part1(input: List<String>): Int = input
        .map { it.toInt() }
        .countValueIncreases()

    fun part2(input: List<String>): Int = input
        .map { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .countValueIncreases()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
