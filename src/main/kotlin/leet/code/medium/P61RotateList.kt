package leet.code.medium

import leet.code.Solution
import leet.code.util.ListNode

class P61RotateList : Solution {

    override fun test() {
        val node = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
        println(rotateRight(node, 2))
    }

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0) return head

        var len = 1
        var tail = head
        while (tail?.next != null) {
            tail = tail.next
            len++
        }

        tail?.next = head

        val actualK = k % len

        val rotations = len - actualK - 1
        var newTail = head
        repeat(rotations) {
            newTail = newTail?.next
        }

        val newHead = newTail?.next
        newTail?.next = null

        return newHead
    }
}
