package leet.code.medium

import leet.code.Solution
import java.util.*


class P721AccountsMerge : Solution {

    override fun test() {
        println(
            accountsMerge(
                listOf(
                    listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                    listOf("John", "johnsmith@mail.com", "john00@mail.com"),
                    listOf("Mary", "mary@mail.com"),
                    listOf("John", "johnnybravo@mail.com")
                )
            )
        )
    }

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val names = mutableMapOf<String, MutableList<Int>>()
        for (id in accounts.indices) {
            val acc = accounts[id]
            for (j in 1..<acc.size) {
                names.getOrPut(acc[j]) { mutableListOf() }.add(id)
            }
        }

        val visited = BooleanArray(accounts.size)

        fun dfs(cur: Int, set: MutableSet<String>) {
            if (visited[cur]) {
                return
            }
            visited[cur] = true
            for (i in 1..<accounts[cur].size) {
                val email = accounts[cur][i]
                set.add(email)
                for (index in names[email]!!) {
                    dfs(index, set)
                }
            }
        }

        val res = mutableListOf<List<String>>()
        for (i in accounts.indices) {
            val set = TreeSet<String>()
            dfs(i, set)
            if (set.isNotEmpty()) {
                val list = set.toMutableList()
                list.add(0, accounts[i][0])
                res.add(list)
            }
        }

        return res
    }
}
