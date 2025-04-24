package leet.code.util

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode(val=$`val`, left=$left, right=$right)"
    }
}

inline fun tnode(`val`: Int, init: TreeNode.() -> Unit = {}) = TreeNode(`val`).apply(init)
