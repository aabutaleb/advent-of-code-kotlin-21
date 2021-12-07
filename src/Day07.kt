import kotlin.math.abs
import kotlin.math.roundToInt

fun main() {
    fun calculateCostsLinear(input: List<Int>, median: Int): Int {
        var cost = 0
        input.forEach { cost += abs(it - median) }
        return cost
    }

    fun calculateCostsIncremental(input: List<Int>, mean: Int): Int {
        var cost = 0
        input.forEach {
            var distance = abs(it - mean)
            cost += ((1+distance)*distance)/2
        }
        return cost
    }

    fun part1(input: List<Int>): Int {
        var median = input.sorted().get(input.size/2)
        return calculateCostsLinear(input, median)
    }

    fun part2(input: List<Int>): Int {
        var mean = input.average().roundToInt()
        var cost = calculateCostsIncremental(input, mean)

        //Go down
        var iter = mean - 1
        var newCost = calculateCostsIncremental(input, iter)
        while (newCost < cost){
            cost = newCost
            iter--
            newCost = calculateCostsIncremental(input, iter)
        }

        //Try up
        iter = mean + 1
        newCost = calculateCostsIncremental(input, iter)
        while (newCost < cost){
            cost = newCost
            iter++
            newCost = calculateCostsIncremental(input, iter)
        }
        return Math.min(cost, newCost)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readCslInt("Day07_test")
    check(part2(testInput) == 168)

    val input = readCslInt("Day07")
    println(part1(input))
    println(part2(input))
}
