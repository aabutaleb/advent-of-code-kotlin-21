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
        println("Mean $mean Cost $cost")
        var iter = mean - 1
        var newCost = calculateCostsIncremental(input, iter)
        println("Pivot $iter Cost $newCost")
        while (newCost < cost){
            cost = newCost
            iter--
            newCost = calculateCostsIncremental(input, iter)
            println("Pivot $iter Cost $newCost")
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
