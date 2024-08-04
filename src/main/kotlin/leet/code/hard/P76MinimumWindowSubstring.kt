package leet.code.hard

import leet.code.Solution

object P76MinimumWindowSubstring : Solution {

    override fun test() {
        println(minWindow(s = "ADOBECODEBANC", t = "ABC"))
        println(minWindow(s = "ab", t = "b"))
        println(minWindow(s = "a", t = "a"))
        println(minWindow(s = "aaaaaaaaaaaabbbbbcdd", t = "abcdd"))
        println(
            minWindow(
                s = "qxsncfwvbslazxuoxnedkukropehlwfbwxqycntdfgghecvdqbhcwtukkauwzzzvystcfohmupvastekunmqiidtjxriyqdyiyapohekxblrurbpgphoykjhjarhtwfduhvkpzumahdxagmivtxvgiepjvxetehnmczddurgdwdecrmzklxqubgfzfjslqizvheadvghrlnvcbxpnuhjxpqywzrkrbjokqpolxxflkapnzeatmltdbrackkwlvmwlbmxbjcmvebieilzwyszckzgulcihpgsssrtdvhaaligvvfrwaqyksegdjqmywfsoyotuxtwieefbjwxjpxvhcemnwzntgfjetdatyydecjgofdzudxbfbqsxpfsvmebijcbhcemfnuvtzupcrthujbuyiovvswdbagjdkxkyrftqbktvdcpogloqajlsgquiyfljcxjveengogbulsitexjeixwqpszoxkzzkiuooiweqxydqjywiiaqhyhwrgkosloetktjuponposfxrdhzdyibhesprjjczoyjhhgyxtnmlulextdatnecsyrlhangonsxxywutligguldpqgiemkymdjufycumwtjupfpdowjkjozzwjdivbvymrdlvzzstkmkpenfcyplnqkjzquutrsgiytdxsvsckftquzstqdihnrgfnbbevjovcutupnyburrpsjijmsqclyjzzk",
                t = "fxtusxonrfdrhxjamdkwm"
            )
        )
    }

    fun minWindow(s: String, t: String): String {
        if (t == "") return ""
        if (s == t) return t

        val m = s.length
        val n = t.length
        if (n > m) return ""

        val counts = t.groupingBy { it }.eachCount()
        val currentCounts = mutableMapOf<Char, Int>()
        var formed = 0
        val required = counts.size

        var left = 0
        var right = 0
        var minLeft = 0
        var minRight = 0
        var minLen = -1
        while (right < s.length) {
            val cRight = s[right]
            currentCounts[cRight] = currentCounts.getOrDefault(cRight, 0) + 1

            val rCount = counts[cRight]
            if (rCount != null && currentCounts[cRight] == rCount) {
                formed++
            }

            while (left <= right && formed == required) {
                val cLeft = s[left]

                if (minLen == -1 || right - left + 1 < minLen) {
                    minLen = right - left + 1
                    minLeft = left
                    minRight = right
                }

                currentCounts[cLeft] = currentCounts.getOrDefault(cLeft, 1) - 1
                val lCount = counts[cLeft]
                if (lCount != null && currentCounts[cLeft]!! < lCount) {
                    formed--
                }

                left++
            }

            right++
        }

        return if (minLen == -1) "" else s.substring(minLeft..minRight)
    }

    // Still too slow :(
//    fun minWindow(s: String, t: String): String {
//        if (s == "" || t == "") return ""
//        if (s == t) return t
//
//        val counts = t.groupingBy { it }.eachCount()
//        val m = s.length
//        val n = t.length
//        if (n > m) return ""
//
//        val window = Window(s)
//        var min: String? = null
//        while (window.left < m - n + 1) {
//            if (window.right == m - 1) {
//                window.incLeft()
//                window.moveRightToLeft()
//            }
//
//            window.incRight()
//            if (window.length < n) continue
//
//            val found = window.countsEqual(counts)
//            if (found && (min == null || window.length < min.length)) {
//                min = window.toString()
//                window.incLeft()
//                window.moveRightToLeft()
//            }
//        }
//
//        return min ?: ""
//    }
//
//    private object Window(private val s: String, var left: Int = -1, var right: Int = -1) {
//
//        private val window = StringBuilder()
//
//        val counts = mutableMapOf<Char, Int>()
//
//        val length: Int
//            get() = window.length
//
//        operator fun get(index: Int) = window[index]
//
//        fun incLeft() {
//            if (left >= s.length) return
//
//            left++
//            if (window.isEmpty()) return
//            val c = window[0]
//            window.deleteAt(0)
//            counts[c] = counts.getOrDefault(c, 1) - 1
//        }
//
//        fun incRight() {
//            if (right >= s.length - 1) return
//
//            right++
//            val c = s[right]
//            window.append(c)
//            counts[c] = counts.getOrDefault(c, 0) + 1
//        }
//
//        fun moveRightToLeft() {
//            window.clear()
//            counts.clear()
//            right = left
//        }
//
//        fun countsEqual(otherCounts: Map<Char, Int>): Boolean = otherCounts.keys.all {
//            val a = otherCounts[it]
//            val b = counts[it]
//            if (a == null || b == null) false else a <= b
//        }
//
//        override fun toString(): String = window.toString()
//    }

    // Works but time limit exceeded
//    fun minWindow(s: String, t: String): String {
//        if (t == "") return ""
//        if (s == t) return t
//
//        val counts = t.groupingBy { it }.eachCount()
//        val m = s.length
//        val n = t.length
//        if (n > m) return ""
//
//        var left = 0
//        var right = n - 1
//        var min: String? = null
//        while (left < m - n + 1) {
//            if (right == m || s[left] !in t) {
//                left++
//                right = min(left + n - 1, m)
//                continue
//            }
//
//            val window = s.substring(left..right)
//            val c = window.groupingBy { it }.eachCount()
//            val found = counts.keys.all {
//                val a = counts[it]
//                val b = c[it]
//                if (a == null || b == null) false else a <= b
//            }
//            if (found && (min == null || window.length < min.length)) {
//                min = window
//                left++
//                right = min(left + n - 1, m)
//            } else {
//                right++
//            }
//        }
//
//        return min ?: ""
//    }
}
