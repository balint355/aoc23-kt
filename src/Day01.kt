fun main() {
    fun part1(input: List<String>): Int {
        var calibrationValuesSum = 0
        input.forEach {
            val foundDigits = mutableListOf<Char>()
            it.forEach { c ->
                if (c.isDigit()) foundDigits.add(c)
            }
            calibrationValuesSum += "${foundDigits.first()}${foundDigits.last()}".toInt()
        }
        return calibrationValuesSum
    }

    fun part2(input: List<String>): Int {
        var calibrationValuesSum = 0
        input.forEach {
            val foundDigits = mutableListOf<Char>()
            it.forEachIndexed { index, c ->
                when {
                    c.isDigit() -> foundDigits.add(c)
                    it.safeSlice(index, index + 5).startsWith("one") -> foundDigits.add('1')
                    it.safeSlice(index, index + 5).startsWith("two") -> foundDigits.add('2')
                    it.safeSlice(index, index + 5).startsWith("three") -> foundDigits.add('3')
                    it.safeSlice(index, index + 5).startsWith("four") -> foundDigits.add('4')
                    it.safeSlice(index, index + 5).startsWith("five") -> foundDigits.add('5')
                    it.safeSlice(index, index + 5).startsWith("six") -> foundDigits.add('6')
                    it.safeSlice(index, index + 5).startsWith("seven") -> foundDigits.add('7')
                    it.safeSlice(index, index + 5).startsWith("eight") -> foundDigits.add('8')
                    it.safeSlice(index, index + 5).startsWith("nine") -> foundDigits.add('9')
                }
            }
            calibrationValuesSum += "${foundDigits.first()}${foundDigits.last()}".toInt()
        }
        return calibrationValuesSum
    }

    val partOneTestInput = readInput("Day01_test_1")
    check(part1(partOneTestInput) == 142)

    val partTwoTestInput = readInput("Day01_test_2")
    check(part2(partTwoTestInput) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
