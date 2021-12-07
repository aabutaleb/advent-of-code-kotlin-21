fun main() {
    fun calculateCosts(input: List<Int>, median: Int): Int {
        var cost = 0
        input.forEach { cost += Math.abs(it - median) }
        return cost
    }

    fun part1(input: List<Int>): Int {
        var median = input.sorted().get(input.size/2)
        return calculateCosts(input, median)
    }

    //Three-measurement sliding window
    fun part2(input: List<Int>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readCslInt("Day07_test")
    check(part1(testInput) == 37)

    val input = readCslInt("Day07")
    println(part1(input))
    println(part2(input))
}
