package leet.code.easy

class P278FirstBadVersion {

    fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right = n
        while (left < right) {
            val mid = left + (right - left) / 2
            if (isBadVersion(mid)) right = mid
            else left = mid + 1
        }
        return left
	}

    // provided
    fun isBadVersion(n: Int) = true
}