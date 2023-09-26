package leet.code.easy

import leet.code.Solution
import leet.code.util.ListNode

class P21MergeTwoSortedLists : Solution {

    override fun test() {
        val list1 = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(4)
            }
        }
        val list2 = ListNode(1).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }

        println(mergeTwoLists(list1, list2))
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }

        val start: ListNode
        var p1 = list1
        var p2 = list2
        if (p1.`val` < p2.`val`) {
            start = p1
            p1 = p1.next
        } else {
            start = p2
            p2 = p2.next
        }

        var l = start
        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                l.next = p1
                p1 = p1.next
            } else {
                l.next = p2
                p2 = p2.next
            }
            l = l.next!!
        }
        if (p1 == null) {
            l.next = p2
        }
        if (p2 == null) {
            l.next = p1
        }

        return start
    }

    // First solution
//    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
//        if (list1 == null) {
//            return list2
//        }
//        if (list2 == null) {
//            return list1
//        }
//
//        val start: ListNode
//        var p1 = list1
//        var p2 = list2
//        if (p1.`val` < p2.`val`) {
//            start = p1
//            p1 = p1.next
//        } else {
//            start = p2
//            p2 = p2.next
//        }
//
//        var l = start
//        while (p1 != null && p2 != null) {
//            if (p1 == null) {
//                l.next = p2
//                p2 = p2.next
//                l = l.next!!
//                continue
//            }
//            if (p2 == null) {
//                l.next = p1
//                p1 = p1.next
//                l = l.next!!
//                continue
//            }
//
//            if (p1.`val` < p2.`val`) {
//                l.next = p1
//                p1 = p1.next
//                l = l.next!!
//            } else {
//                l.next = p2
//                p2 = p2.next
//                l = l.next!!
//            }
//        }
//        if (p1 == null) {
//            l.next = p2
//        }
//        if (p2 == null) {
//            l.next = p1
//        }
//
//        return start
//    }
}
