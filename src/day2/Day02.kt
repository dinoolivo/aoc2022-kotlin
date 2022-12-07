package day2

import readInput

fun main() {

    val scoreMatrixPart1:Array<Array<Int>> = arrayOf(arrayOf(4,8,3), arrayOf(1,5,9), arrayOf(7,2,6))
    val scoreMatrixPart2:Array<Array<Int>> = arrayOf(arrayOf(3,4,8,), arrayOf(1,5,9), arrayOf(2,6,7))

    fun fromCode(code: String):Int = when (code) {
            "X", "A" -> 0
            "Y", "B" -> 1
            "Z", "C" -> 2
            else -> -1
    }

    fun codePairs(row:String):Pair<Int,Int> {
        val cols = row.split(" ")
        return Pair(fromCode(cols[0]), fromCode(cols[1]))
    }

    fun part1(input: List<Pair<Int,Int>>): Int =  input.sumOf { codes ->
            scoreMatrixPart1[codes.first][codes.second]
    }

    fun part2(input: List<Pair<Int,Int>>): Int =  input.sumOf { codes ->
        scoreMatrixPart2[codes.first][codes.second]
    }


    val testInput = readInput("inputs/Day02_test").map(::codePairs)
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = readInput("inputs/Day02").map(::codePairs)
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}
