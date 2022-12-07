package day7

import readInput

fun main() {
    fun part1(tree: Tree): Long {
       return tree.getAllNodesByCondition { treeNode ->  treeNode.metadata.isDir() && treeNode.metadata.size <= 100000}
           .sumOf { treeNode -> treeNode.metadata.size }
    }

    fun part2(tree: Tree): Long {
        val currentFreeSpace = 70000000L -tree.root.metadata.size
        val neededSpace = 30000000 - currentFreeSpace
        return tree.getAllNodesByCondition { treeNode -> treeNode.metadata.isDir() && treeNode.metadata.size >= neededSpace }
            .map { node -> node.metadata.size }.minOf { it }
    }

    fun loadTree(input: List<String>): Tree {
        val tree = Tree()
        for(line in input){
            if(line.startsWith("$")){
                val lineParts = line.split(" ")
                if(lineParts[1] == "cd"){
                    if(lineParts[2] == "/"){
                        tree.addRoot(TreeNode(Metadata("/", Type.Dir, 0), null))
                    }else if(lineParts[2] == ".."){
                        tree.moveUp()
                    }else{
                        tree.moveTo(lineParts[2])
                    }
                }else if(lineParts[1] == "ls"){
                    continue
                }
            }else{
                val lineParts = line.split(" ")
                if(lineParts[0] == Type.Dir.toString()){
                    tree.currentNode?.addChild(TreeNode(Metadata(lineParts[1], Type.Dir, 0), tree.currentNode))
                }else{
                    val fileSize = lineParts[0].toLong()
                    tree.currentNode?.addChild(TreeNode(Metadata(lineParts[1], Type.File, fileSize), tree.currentNode))
                    tree.propagateUp { currentNode -> currentNode.metadata.addSize(fileSize) }
                }
            }
        }
        return tree
    }


  val testInput = loadTree(readInput("inputs/Day07_test"))
    testInput.printTree()
    println("Test Part 1: " + part1(testInput))
    println("Test Part 2: " + part2(testInput))

    //execute the two parts on the real input
    val input = loadTree(readInput("inputs/Day07"))
    //input.printTree()
    println("Part1: " + part1(input))
    println("Part2: " + part2(input))
}
