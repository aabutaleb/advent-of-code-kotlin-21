fun main() {

    fun part1(input: List<String>): Int {
        // first in pair is the array index in the position, second is the
        // positive/negative multiplier of depth
        val instructions = mapOf<String, Pair<Int, Int>>("forward" to Pair(0, 1),
                "down" to Pair (1, 1),
                "up" to Pair (1, -1))

        var pos =  IntArray(2) {0}

        input.map { it.split(" ") }.forEach {
            var i: Pair<Int, Int>? = instructions[it[0]]
            if (i != null)
                pos[i.first] += it[1].toInt() * i.second
        }
        return pos[0] * pos[1]
    }

    fun part2(input: List<String>): Int {
        // first in Pair is the array index in the position, second is the
        // positive/negative multiplier of aim, works for up/down, special case
        // on forward to increase depth
        val instructions = mapOf<String, Pair<Int, Int>>("forward" to Pair(0, 1),
                "down" to Pair (2, 1),
                "up" to Pair (2, -1))

        var pos =  IntArray(3) {0}

        input.map { it.split(" ") }.forEach {
            var i: Pair<Int, Int>? = instructions[it[0]]
            if (i != null) {
                pos[i.first] += it[1].toInt() * i.second
                if (it[0].equals("forward")) // Special case, could be improved
                    pos[1] += pos[2] * it[1].toInt()
            }

        }
        return pos[0] * pos[1]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputString("Day02_test")
    check(part2(testInput) == 900)

    val input = readInputString("Day02")
    println(part1(input))
    println(part2(input))
}
