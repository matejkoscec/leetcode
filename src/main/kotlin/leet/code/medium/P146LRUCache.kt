package leet.code.medium

import leet.code.Solution


class P146LRUCache : Solution {

    class LRUCache(private val capacity: Int) {

        class Node(val key: Int, val value: Int) {
            lateinit var prev: Node
            lateinit var next: Node
        }

        private val cache = mutableMapOf<Int, Node>()
        private val oldest = Node(0, 0)
        private val latest = Node(0, 0)

        init {
            oldest.next = latest
            latest.prev = oldest
        }

        fun get(key: Int): Int {
            val node = cache[key] ?: return -1
            remove(node)
            insert(node)
            return node.value
        }

        private fun remove(node: Node) {
            val prev = node.prev
            val next = node.next
            prev.next = next
            next.prev = prev
        }

        private fun insert(node: Node) {
            val prev = latest.prev
            val next = latest
            next.prev = node
            prev.next = next.prev
            node.next = next
            node.prev = prev
        }

        fun put(key: Int, value: Int) {
            cache[key]?.let(::remove)
            cache[key] = Node(key, value).also(::insert)
            if (cache.size > capacity) {
                val lru = oldest.next
                remove(lru)
                cache.remove(lru.key)
            }
        }
    }

    override fun test() {

    }
}
