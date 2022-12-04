import java.util.stream.Collectors

fun main() {

    //subtract the code of 'a' if lowercase or 'A' if uppercase then sum the known priority range (a to z priorities 1 through 26 and A to Z priorities 27 through 52)
    fun computePriority(itemType:Char) = if(itemType.isUpperCase()) itemType.code -'A'.code + 27 else itemType.code - 'a'.code + 1

    /*
     * divide the string containing the list of items in the two compartments by using a substring
     * then transform the string in a set of characters since we are interested only on distinct chars
     * that are contained in both compartments not the number of occurrences.
     * Then intersect the two sets and get only the chars contained in both and compute the score for each row.
     * Last step is to sum all the computed priorities, first for each row and then for all the rows
     */
    fun part1(input: List<String>): Int = input.sumOf {row ->
            val sect1 = row.substring(0, row.length/2).toSet()
            val sect2 = row.substring(row.length/2).toSet()
            sect1.intersect(sect2).sumOf(::computePriority)
    }

    /*
    Same as part 1. The only difference is regarding the input that in this case is chunked in groups of three rows
     */
    fun part2(input: List<String>): Int = input.chunked(3).sumOf {
            group ->
            group[0].toSet().intersect(group[1].toSet()).intersect(group[2].toSet()).sumOf(::computePriority)
    }

    val testInput = readInput("inputs/Day03_test")
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = readInput("inputs/Day03")
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}