package leet.code.medium

import leet.code.Solution
import leet.code.util.ListNode

class P19RemoveNthNodeFromEnd : Solution {

    override fun test() {
        val head = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5)
                    }
                }
            }
        }

        println(removeNthFromEnd(head, 5))
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) {
            return null
        }

        var i = 1
        var prev: ListNode? = null
        var node = head.next
        while (node != null) {
            if (i >= n) {
                prev = if (prev == null) head else prev.next
            }
            i++
            node = node.next
        }
        if (prev == null) {
            node = head.next
            return node
        }
        prev.next = prev.next?.next

        return head
    }
}
