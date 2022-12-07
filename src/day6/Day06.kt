package day6

import readInputAsText

fun main() {

    /**
     * @param signal the input string containing the signal to process
     * @param subSignalSize the size of the substring of the signal that has to be processed at time
     * returns the index of the first packet marker or -1 if no marker is found in input signal
     */
    fun findStartOfPacketMarker(signal: String, subSignalSize:Int):Int{
        for(startIndex in IntRange(0, signal.length-subSignalSize)){
            val subSignal = signal.subSequence(startIndex, startIndex+subSignalSize)
            if(subSignal.length == subSignal.toSet().size) return startIndex+subSignalSize
        }
        return -1
    }

    fun part1(input: String): Int = findStartOfPacketMarker(input, subSignalSize = 4)

    fun part2(input: String): Int = findStartOfPacketMarker(input, subSignalSize = 14)


    // verify that the solution works with test data
    val testInput = readInputAsText("inputs/Day06_test")
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = readInputAsText("inputs/Day06")
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}


