package leet.code.easy

import leet.code.Solution

class P70ClimbingStairs : Solution {

    override fun test() {
        println(climbStairs(10))
    }

    fun climbStairs(n: Int): Int {
        var prev = 1
        var curr = 1
        for (i in 2..n) {
            prev = curr.also { curr += prev }
        }
        return curr
    }
}