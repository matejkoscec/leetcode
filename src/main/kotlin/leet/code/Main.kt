package leet.code

import leet.code.easy.*
import leet.code.hard.*
import leet.code.medium.*

fun interface Solution {
    fun test()
}

val solutions = mapOf(
    // easy
    "longestCommonPrefix" to P14LongestCommonPrefix(),
    "mergeTwoSortedLists" to P21MergeTwoSortedLists(),
    "removeDuplicatesFromSortedArray" to P26RemoveDuplicatesFromSortedArray(),
    "removeElement" to P27RemoveElement(),
    "findIndexOfFirstOccurrence" to P28FindIndexOfFirstOccurrence(),
    "searchInsert" to P35SearchInsert(),
    "lengthOfLastWord" to P58LengthOfLastWord(),
    "plusOne" to P66PlusOne(),
    "addBinary" to P67AddBinary(),
    "mergeSortedArray" to P88MergeSortedArray(),
    "convertSortedArrayToBinarySearchTree" to P108ConvertSortedArrayToBinarySearchTree(),
    "validPalindrome" to P125ValidPalindrome(),

    // medium
    "addTwoNumbers" to P2AddTwoNumbers(),
    "longestSubstringWithoutRepeatingChars" to P3LongestSubstringWithoutRepeatingChars(),
    "zigZagConversion" to P6ZigZagConversion(),
    "reverseInteger" to P7ReverseInteger(),
    "stringToInteger" to P8StringToInteger(),
    "containerWithMostWater" to P11ContainerWithMostWater(),
    "integerToRoman" to P12IntegerToRoman(),
    "3Sum" to P15ThreeSum(),
    "letterCombinationsOfAPhoneNumber" to P17LetterCombinationsOfAPhoneNumber(),
    "removeNthNodeFromEnd" to P19RemoveNthNodeFromEnd(),
    "generateParentheses" to P22GenerateParentheses(),
    "swapNodesInPairs" to P24SwapNodesInPairs(),
    "nextPermutation" to P31NextPermutation(),
    "searchInRotatedSortedArray" to P33SearchInRotatedSortedArray(),
    "findFirstLastPositionOfElementInSortedArray" to P34FindFirstLastPositionOfElementInSortedArray(),
    "validSudoku" to P36ValidSudoku(),
    "combinationSum" to P39CombinationSum(),
    "jumpGame2" to P45JumpGame2(),
    "permutations" to P46Permutations(),
    "rotateImage" to P48RotateImage(),
    "powXN" to P50PowXN(),

    // hard
    "medianOfTwoSortedArrays" to P4MedianOfTwoSortedArrays(),
    "regularExpressionMatching" to P10RegularExpressionMatching(),
    "mergeKSortedLists" to P23MergeKSortedLists(),
    "reverseNodesInKGroup" to P25ReverseNodesInKGroup(),
    "substringWithConcatOfAllWords" to P30SubstringWithConcatOfAllWords(),
    "longestValidParentheses" to P32LongestValidParentheses(),
    "sudokuSolver" to P37SudokuSolver(),
    "firstMissingPositive" to P41FirstMissingPositive(),
    "trappingRainWater" to P42TrappingRainWater(),
    "wildcardMatching" to P44WildcardMatching(),
)

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Specify the solution name")
        return
    }

    val solution = args[0]
    solutions[solution]?.test() ?: println("Solution $solution not found.")
}
