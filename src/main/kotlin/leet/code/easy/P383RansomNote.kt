package leet.code.easy

class P383RansomNote {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomCounts = ransomNote.groupingBy { it }.eachCount()
        val magazineCounts = magazine.groupingBy { it }.eachCount()

        return ransomCounts.all { (k, v) ->
            val count = magazineCounts[k] ?: return false
            count >= v
        }
    }
}