package leet.code.medium

import leet.code.Solution
import leet.code.util.ListNode

class P24SwapNodesInPairs : Solution {

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

        println(swapPairs(head))
    }

    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var n1 = head
        var n2 = head.next
        val dummy = n2
        var latter = n2?.next
        var prev: ListNode? = null
        do {
            // swap
            n1?.next = latter
            n2?.next = n1
            prev?.next = n2

            // move
            prev = n1
            n1 = latter
            n2 = latter?.next
            latter = n2?.next
        } while (n2 != null)

        return dummy
    }
}
