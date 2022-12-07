package day7

class Tree (){

    lateinit var root:TreeNode
    var currentNode:TreeNode? = null

    fun addRoot(root:TreeNode){
        this.root = root
        this.currentNode = root
    }

    fun moveTo(name:String){
        this.currentNode = this.currentNode?.getChild(name)
    }

    fun  moveUp(){
        this.currentNode = this.currentNode?.parent
    }

    fun propagateUp(action: (TreeNode) -> Unit){
        var tempCurrent = this.currentNode!!
        while (tempCurrent != root){
            action(tempCurrent)
            tempCurrent = tempCurrent.parent!!
        }
        action(tempCurrent) //to propagate to root
    }

    fun getAllNodesByCondition(condition: (TreeNode) -> Boolean):List<TreeNode>{
       return getAllNodesByConditionFromNode(this.root, condition)
    }

    private fun getAllNodesByConditionFromNode(node:TreeNode, condition: (TreeNode) -> Boolean):List<TreeNode>{
        val result:MutableList<TreeNode> = ArrayList()
        for(tempNode in node.getChildren()){
            if(condition(tempNode)) result.add(tempNode)
            result.addAll(getAllNodesByConditionFromNode(tempNode, condition))
        }
        return result
    }

    fun printTree(){
        printTree(0, root)
    }

    private fun printTree(spaces: Int, node: TreeNode){
        for(i in 0 until spaces){
            print(" ")
        }
        print("- ")
        println(node.metadata.toString())
        for(tempNode in node.getChildren()){
            printTree(spaces + 1, tempNode)
        }
    }
}