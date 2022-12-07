package day7

import java.util.concurrent.locks.Condition
import java.util.function.Predicate

class TreeNode(
    val metadata: Metadata,
    val parent: TreeNode?,
    private val children: MutableMap<String, TreeNode> = HashMap()
) {

    fun addChild(child: TreeNode) {
        this.children[child.metadata.name] = child
    }

    fun getChild(name: String): TreeNode? {
        return this.children[name]
    }

    fun getChildren():List<TreeNode>{
        return this.children.values.toList()
    }


}