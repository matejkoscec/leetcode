package leet.code.easy

import leet.code.Solution

class P14LongestCommonPrefix : Solution {

    override fun test() {
        TODO("Not yet implemented")
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = strs[0]
        for (i in 1..<strs.size) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length - 1)
                if (prefix.isEmpty()) {
                    return ""
                }
            }
        }

        return prefix
    }
}

/*

Original java solution

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}

*/
