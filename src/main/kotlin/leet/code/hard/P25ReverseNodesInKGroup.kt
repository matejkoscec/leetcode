package leet.code.hard

import leet.code.Solution
import leet.code.util.ListNode

object P25ReverseNodesInKGroup : Solution {

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

        println(reverseKGroup(head, 2))
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k <= 1) {
            return head
        }

        var len = 0
        var node = head
        while (node != null) {
            node = node.next
            len++
        }
        val groups = len / k

        node = head
        var dummy: ListNode? = null
        var prev: ListNode? = null
        val groupList = mutableListOf<ListNode?>()
        val groupHeads = mutableListOf<ListNode?>()
        var window = 0
        var g = 0
        while (g < groups) {
            if (window == k) {
                if (dummy == null) {
                    dummy = prev
                }
                groupList.add(prev)
                prev = null
                window = 0
                g++
            } else {
                val temp = node?.next
                node?.next = prev
                if (node?.next == null) {
                    groupHeads.add(node)
                }
                prev = node
                node = temp
                window++
            }
        }
        if (node != null) {
            groupList.add(node)
        }

        for (i in groupHeads.indices) {
            if (i < groupList.size - 1) {
                groupHeads[i]?.next = groupList[i + 1]
            }
        }

        return dummy
    }
}
