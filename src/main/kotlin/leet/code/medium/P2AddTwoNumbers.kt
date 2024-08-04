package leet.code.medium

import leet.code.Solution
import leet.code.util.ListNode

class P2AddTwoNumbers : Solution {

    override fun test() {
        val l1 = ListNode(9, ListNode(9))
        val l2 = ListNode(9, ListNode(9, ListNode(9, ListNode(9))))
        var out = addTwoNumbers(l1, l2)
        while (out.next != null) {
            println(out.`val`)
            out = out.next!!
        }
        println(out.`val`)
    }

    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        val sizeOf1 = sizeOf(l1)
        val sizeOf2 = sizeOf(l2)
        val min = sizeOf1.coerceAtMost(sizeOf2)

        val result = ListNode()
        var resultNext: ListNode? = result
        var next1: ListNode? = l1
        var next2: ListNode? = l2
        var carry = 0
        for (i in 0..<min) {
            val sum = next1!!.`val` + next2!!.`val` + carry
            carry = if (sum >= 10) 1 else 0
            resultNext!!.`val` = sum % 10
            if (i == min - 1) {
                break
            }
            resultNext.next = ListNode()
            resultNext = resultNext.next
            next1 = next1.next
            next2 = next2.next
        }
        if (sizeOf1 != sizeOf2) {
            var next = if (sizeOf1 == min) next2!!.next else next1!!.next
            var sum = next!!.`val` + carry
            carry = if (sum >= 10) 1 else 0
            resultNext!!.next = ListNode(sum % 10)
            next = next.next
            resultNext = resultNext.next
            while (next != null) {
                sum = next.`val` + carry
                carry = if (sum >= 10) 1 else 0
                resultNext!!.next = ListNode(sum % 10)
                next = next.next
                resultNext = resultNext.next
            }
        }
        if (carry > 0) {
            resultNext!!.next = ListNode(carry)
        }
        return result
    }

    private fun sizeOf(listNode: ListNode): Int {
        var size = 1
        var next: ListNode? = listNode
        while (next!!.next != null) {
            size++
            next = next.next
        }
        return size
    }
}

/*
Original java code

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sizeOf1 = sizeOf(l1);
        int sizeOf2 = sizeOf(l2);
        int min = Math.min(sizeOf1, sizeOf2);

        ListNode result = new ListNode();
        ListNode resultNext = result;
        int carry = 0;
        for (int i = 0; i < min; i++) {
            int sum = l1.val + l2.val + carry;
            carry = (sum >= 10) ? 1 : 0;
            resultNext.val = sum % 10;

            if (i == min - 1) {
                break;
            }
            resultNext.next = new ListNode();
            resultNext = resultNext.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (sizeOf1 != sizeOf2) {
            ListNode next = sizeOf1 == min ? l2.next : l1.next;

            int sum = next.val + carry;
            carry = (sum >= 10) ? 1 : 0;
            resultNext.next = new ListNode(sum % 10);
            next = next.next;
            resultNext = resultNext.next;

            while (next != null) {
                sum = next.val + carry;
                carry = (sum >= 10) ? 1 : 0;
                resultNext.next = new ListNode(sum % 10);
                next = next.next;
                resultNext = resultNext.next;
            }
        }
        if (carry > 0) {
            resultNext.next = new ListNode(carry);
        }

        return result;
    }

    private int sizeOf(ListNode listNode) {
        int size = 1;
        ListNode next = listNode;
        while (next.next != null) {
            size++;
            next = next.next;
        }
        return size;
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
 */
