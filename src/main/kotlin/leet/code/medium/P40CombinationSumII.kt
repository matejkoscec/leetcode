package leet.code.medium

import leet.code.Solution
import java.util.*


class P40CombinationSumII : Solution {

    override fun test() {

    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        val res = mutableListOf<List<Int>>()

        fun dfs(start: Int, comb: MutableList<Int>) {
            if (target < 0) {
                return
            }
            if (target == 0) {
                res.add(comb.toList())
                return
            }
            for (i in start..<candidates.size) {
                if (i > start && candidates[i] == candidates[i - 1]) continue
                if (candidates[i] > target) break

                comb.add(candidates[i])
                dfs(target - candidates[i], comb)
                comb.removeAt(comb.size - 1)
            }
        }

        dfs(0, mutableListOf())

        return res
    }
}
