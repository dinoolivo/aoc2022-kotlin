package day1

import readInput

fun main() {
    fun part1(input: List<Int>): Int {
        return input.first()
    }

    fun part2(input: List<Int>): Int {
        return input.take(3).sum()
    }

    fun clusterByCondition(input: List<String>): List<List<Int>> =
        input.foldIndexed(arrayListOf(ArrayList<Int>())) { _, acc, item ->
            if (item.isBlank()) {
                acc.add(ArrayList())
            }else{
                acc.last().add(item.toInt())
            }
            acc
        }

    fun sortedCalories(input: List<List<Int>>) = input.map { calories -> calories.sum() }.sortedDescending()


    val testInput = sortedCalories(clusterByCondition(readInput("inputs/Day01_test")))
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = sortedCalories(clusterByCondition(readInput("inputs/Day01")))
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}
