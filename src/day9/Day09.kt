package day9

import readInput

fun main() {

    fun findNumVisitedByTail(input: List<String>, numRopeNodes:Int): Int {
        val ropeNodes = mutableListOf<Position>()
        for(i in 0 until numRopeNodes){
            ropeNodes.add(Position(0,0))
        }
        val visited = HashSet<Position>()
        for(direction in input){
            val directionParts = direction.split(" ")
            val funcToApply:(Position) -> Position = when(directionParts[0]){
                "R" -> ::moveRight
                "L" -> ::moveLeft
                "U" -> ::moveTop
                "D" -> ::moveBottom
                else -> ::doNotMove
            }
            for(i in 0 until directionParts[1].toInt()){
                ropeNodes[0] = funcToApply(ropeNodes[0])
                for(j in 1 until numRopeNodes){
                    ropeNodes[j] = ropeNodes[j].positionToBeAdjacent(ropeNodes[j-1])
                }
                visited.add(ropeNodes[ropeNodes.size-1])
            }
        }
        return visited.size
    }

    fun part1(input: List<String>): Int = findNumVisitedByTail(input, 2)
    fun part2(input: List<String>): Int = findNumVisitedByTail(input, 10)


    val testInput = (readInput("inputs/Day09_test"))
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = readInput("inputs/Day09")
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}
