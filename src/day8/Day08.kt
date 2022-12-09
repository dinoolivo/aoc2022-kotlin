package day8

import readInput

fun main() {

    fun treeMatrix(input: List<String>): List<List<Int>> = input.map { row -> row.map { elem -> elem.digitToInt() } }

    fun scenicScoreFromLeft(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Int {
        var leftIndex = colIndex - 1
        while (leftIndex > 0 && input[rowIndex][colIndex] > input[rowIndex][leftIndex]) leftIndex--
        val score = colIndex - leftIndex
        return if (leftIndex < 0) score - 1 else score
    }

    fun isVisibleFromLeft(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Boolean {
        var leftIndex = colIndex - 1
        while (leftIndex >= 0 && input[rowIndex][colIndex] > input[rowIndex][leftIndex]) leftIndex--
        return leftIndex < 0
    }

    fun scenicScoreFromRight(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Int {
        var rightIndex = colIndex + 1
        while (rightIndex < input.size && input[rowIndex][colIndex] > input[rowIndex][rightIndex]) rightIndex++
        val score = rightIndex - colIndex
        return if (rightIndex == input.size) score - 1 else score
    }

    fun isVisibleFromRight(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Boolean {
        var rightIndex = colIndex + 1
        while (rightIndex < input.size && input[rowIndex][colIndex] > input[rowIndex][rightIndex]) rightIndex++
        return rightIndex == input.size
    }

    fun scenicScoreFromTop(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Int {
        var topIndex = rowIndex - 1
        while (topIndex > 0 && input[rowIndex][colIndex] > input[topIndex][colIndex]) topIndex--
        val score = rowIndex - topIndex
        return if (topIndex < 0) score - 1 else score
    }

    fun isVisibleFromTop(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Boolean {
        var topIndex = rowIndex - 1
        while (topIndex >= 0 && input[rowIndex][colIndex] > input[topIndex][colIndex]) topIndex--
        return topIndex < 0
    }

    fun scenicScoreFromBottom(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Int {
        var bottomIndex = rowIndex + 1
        while (bottomIndex < input.size && input[rowIndex][colIndex] > input[bottomIndex][colIndex]) bottomIndex++
        val score = bottomIndex - rowIndex
        return if (bottomIndex == input.size) score - 1 else score
    }

    fun isVisibleFromBottom(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Boolean {
        var bottomIndex = rowIndex + 1
        while (bottomIndex < input.size && input[rowIndex][colIndex] > input[bottomIndex][colIndex]) bottomIndex++
        return bottomIndex == input.size
    }

    fun scenicScore(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Int =
        scenicScoreFromLeft(input, rowIndex, colIndex) * scenicScoreFromRight(input, rowIndex, colIndex) *
                scenicScoreFromTop(input, rowIndex, colIndex) * scenicScoreFromBottom(input, rowIndex, colIndex)

    fun isVisible(input: List<List<Int>>, rowIndex: Int, colIndex: Int): Boolean =
        isVisibleFromLeft(input, rowIndex, colIndex) || isVisibleFromRight(input, rowIndex, colIndex) ||
                isVisibleFromTop(input, rowIndex, colIndex) || isVisibleFromBottom(input, rowIndex, colIndex)

    fun part1(input: List<List<Int>>): Int {
        val squareSize = input.size
        var visibleTrees = 4 * (squareSize - 1)
        for (rowIndex in 1 until squareSize - 1) {
            for (colIndex in 1 until squareSize - 1) {
                if (isVisible(input, rowIndex, colIndex)) {
                    visibleTrees = visibleTrees.inc()
                }
            }
        }
        return visibleTrees
    }


    fun part2(input: List<List<Int>>): Int {
        val squareSize = input.size
        val scores = mutableListOf<Int>()
        for (rowIndex in 1 until squareSize - 1) {
            for (colIndex in 1 until squareSize - 1) {
                val score = scenicScore(input, rowIndex, colIndex)
                scores.add(score)
            }
        }
        return scores.max()
    }


    val testInput = treeMatrix(readInput("inputs/Day08_test"))
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = treeMatrix(readInput("inputs/Day08"))
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}
