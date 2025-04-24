package leet.code.medium

import leet.code.Solution

class `P208ImplementTrie(PrefixTree)` : Solution {

    override fun test() {

    }

    class Node(
        var isTerminal: Boolean = false,
        val children: Array<Node?> = arrayOfNulls(26)
    )

    private val root = Node()

    fun insert(word: String) {
        var node = root
        for (c in word) {
            if (node.children[c.lowercaseChar() - 'a'] == null) {
                node.children[c.lowercaseChar() - 'a'] = Node()
            }
            node = node.children[c.lowercaseChar() - 'a']!!
        }
        node.isTerminal = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (c in word) {
            node = node.children[c.lowercaseChar() - 'a'] ?: return false
        }
        return node.isTerminal
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (c in prefix) {
            node = node.children[c.lowercaseChar() - 'a'] ?: return false
        }
        return true
    }
}