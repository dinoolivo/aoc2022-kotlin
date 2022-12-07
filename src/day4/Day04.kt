package day4

import day3.Interval
import readInput

fun main() {

    fun convertToIntervals(input: String):Pair<Interval, Interval>{
        val rowParts = input.split(",")
        return  Pair(Interval.fromString(rowParts[0]), Interval.fromString(rowParts[1]))
    }

    fun part1(input: List<Pair<Interval, Interval>>): Int = input.sumOf { intervals ->
            if (intervals.first.contains(intervals.second) || intervals.second.contains(intervals.first)) 1 as Int else 0
    }


    fun part2(input: List<Pair<Interval, Interval>>): Int = input.sumOf { intervals ->
            if (intervals.first.overlaps(intervals.second)) 1 as Int else 0
    }


    // verify that the solution works with test data
    val testInput = readInput("inputs/Day04_test").map(::convertToIntervals)
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = readInput("inputs/Day04").map(::convertToIntervals)
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}


