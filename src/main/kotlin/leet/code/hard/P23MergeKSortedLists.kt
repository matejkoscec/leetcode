package leet.code.hard

import leet.code.Solution
import leet.code.util.ListNode
import java.util.PriorityQueue

class P23MergeKSortedLists : Solution {

    override fun test() {
        val list1 = ListNode(1).apply {
            next = ListNode(4).apply {
                next = ListNode(5)
            }
        }
        val list2 = ListNode(1).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
        val list3 = ListNode(2).apply {
            next = ListNode(6)
        }

        println(mergeKLists(arrayOf(list1, list2, list3)))
        println(mergeKLists(arrayOf(null, ListNode(1))))
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val priorityQueue = PriorityQueue<Int>()

        for (root in lists) {
            var node = root
            while (node != null) {
                priorityQueue.add(node.`val`)
                node = node.next
            }
        }

        if (priorityQueue.isEmpty()) {
            return null
        }

        val head = ListNode(priorityQueue.poll())
        var node = head
        while (priorityQueue.isNotEmpty()) {
            node.next = ListNode(priorityQueue.poll()).also { node = it }
        }

        return head
    }

    // Fastest
//    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
//        return merge(lists, 0, lists.size - 1)
//    }
//
//    fun merge(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
//        if (left > right) {
//            return null
//        }
//        if (left == right) {
//            return lists[left]
//        }
//
//        val mid = left + (right - left) / 2
//        val l1 = merge(lists, left, mid)
//        val l2 = merge(lists, mid + 1, right)
//
//        return mergeTwoLists(l1, l2)
//    }
//
//    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
//        if (l1 == null) {
//            return l2
//        } else if (l2 == null) {
//            return l1
//        }
//
//        return if (l1.`val` < l2.`val`) {
//            l1.next = mergeTwoLists(l1.next, l2)
//            l1
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next)
//            l2
//        }
//    }

    // First solution
//    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
//        if (lists.isEmpty()) {
//            return null
//        }
//
//        var start = lists[0]
//        var minI = 0
//        for (j in 1..<lists.size) {
//            val node = lists[j] ?: continue
//            if (start == null) {
//                minI = j
//                start = node
//            }
//            if (node.`val` < start.`val`) {
//                start = node
//                minI = j
//            }
//        }
//        if (start == null) {
//            return null
//        }
//        lists[minI] = lists[minI]?.next
//
//        var l = start
//        var nulls = 0
//        while (nulls < lists.size) {
//            nulls = 0
//            var min = lists[0]
//            if (min == null) {
//                nulls++
//            }
//            minI = 0
//            for (i in 1..<lists.size) {
//                val node = lists[i]
//                if (node == null) {
//                    nulls++
//                    continue
//                }
//                if (min == null) {
//                    min = node
//                    minI = i
//                    continue
//                }
//                if (node.`val` < min.`val`) {
//                    min = node
//                    minI = i
//                }
//            }
//            if (min == null) {
//                break
//            }
//            l?.next = min
//            lists[minI] = lists[minI]?.next
//            l = l?.next
//        }
//
//        return start
//    }
}
