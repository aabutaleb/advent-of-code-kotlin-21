fun main() {
    fun part1(input: List<Int>): Int {
        var count = 0
        var prev = Int.MAX_VALUE
        for (measurement in input){
            if (measurement > prev) count++
            prev = measurement
        }
        return count
    }

    //Three-measurement sliding window
    fun part2(input: List<Int>): Int {
        var count = 0
        var prev = Int.MAX_VALUE
        for (i in 2 until input.size){
            var measurement = input[i] + input[i-1] + input[i-2]
            if (measurement > prev) count++
            prev = measurement
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputInt("Day01_test")
    check(part2(testInput) == 5)

    val input = readInputInt("Day01")
    println(part1(input))
    println(part2(input))
}
