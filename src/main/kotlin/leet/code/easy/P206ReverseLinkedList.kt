package leet.code.easy

import leet.code.Solution
import leet.code.util.ListNode
import leet.code.util.toLinkedList

object P206ReverseLinkedList : Solution {

    override fun test() {
        val head = (1..5).toLinkedList()
        println(head)
        println(reverseList(head))
    }

    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head

        while (curr != null) {
            val forward = curr.next
            curr.next = prev
            prev = curr
            curr = forward
        }

        return prev
    }
}