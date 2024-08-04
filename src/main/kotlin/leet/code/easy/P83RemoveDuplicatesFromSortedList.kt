package leet.code.easy

import leet.code.Solution
import leet.code.util.ListNode

class P83RemoveDuplicatesFromSortedList : Solution {

    override fun test() {

    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }

        var prev: ListNode = head
        var next = head.next
        while (next != null) {
            if (next.`val` == prev.`val`) {
                prev.next = next.next
            } else {
                prev = next
            }
            next = next.next
        }

        return head
    }
}