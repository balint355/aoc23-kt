fun main() {
    fun part1(input: List<String>): Int =
        input.fold(0) { acc, next ->
            val gameIdPattern = Regex("""Game ([0-9]+)""")
            val redPattern = Regex("""([0-9]+) red""")
            val greenPattern = Regex("""([0-9]+) green""")
            val bluePattern = Regex("""([0-9]+) blue""")

            val gameId = gameIdPattern.find(next)!!.groupValues[1].toInt()
            val maxRed = redPattern.findAll(next).map { match ->
                match.groupValues[1].toInt()
            }.max()
            val maxGreen = greenPattern.findAll(next).map { match ->
                match.groupValues[1].toInt()
            }.max()
            val maxBlue = bluePattern.findAll(next).map { match ->
                match.groupValues[1].toInt()
            }.max()

            val result = if (maxRed <= 12 && maxGreen <= 13 && maxBlue <= 14) acc + gameId else acc
            result
        }

    fun part2(input: List<String>): Int =
        input.fold(0) { acc, next ->
            val redPattern = Regex("""([0-9]+) red""")
            val greenPattern = Regex("""([0-9]+) green""")
            val bluePattern = Regex("""([0-9]+) blue""")

            val maxRed = redPattern.findAll(next).map { match ->
                match.groupValues[1].toInt()
            }.max()
            val maxGreen = greenPattern.findAll(next).map { match ->
                match.groupValues[1].toInt()
            }.max()
            val maxBlue = bluePattern.findAll(next).map { match ->
                match.groupValues[1].toInt()
            }.max()

            acc + maxRed * maxGreen * maxBlue
        }

    val partOneTestInput = readInput("Day02_test_1")
    check(part1(partOneTestInput) == 8)

    val partTwoTestInput = readInput("Day02_test_2")
    check(part2(partTwoTestInput) == 2286)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
