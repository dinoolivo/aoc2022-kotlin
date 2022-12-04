fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    /*fun clusterByCondition(input: List<String>):List<List<Int>>{
        input.foldIndexed(ArrayList<ArrayList<Int>>()){
            index, acc, row ->
        }
    }*/

    val testInput = readInput("inputs/Day01_test")
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = readInput("inputs/Day01")
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}
