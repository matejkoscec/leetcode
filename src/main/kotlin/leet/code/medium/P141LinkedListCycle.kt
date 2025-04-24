package leet.code.medium

import leet.code.Solution
import leet.code.util.ListNode

class P141LinkedListCycle : Solution {

    override fun test() {

    }

    fun hasCycle(head: ListNode?): Boolean {
        var first = head
        var second = head
        while (first != null && second != null) {
            first = first.next
            second = second.next?.next
            if (first != null && second != null && first == second) return true
        }

        return false
    }
}