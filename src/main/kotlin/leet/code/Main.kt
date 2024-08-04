package leet.code

import leet.code.easy.*
import leet.code.hard.*
import leet.code.medium.*
import leet.code.random.WordMap

fun interface Solution {
    fun test()
}

val solutions = mapOf(
    // easy
    "longestCommonPrefix" to P14LongestCommonPrefix,
    "mergeTwoSortedLists" to P21MergeTwoSortedLists,
    "removeDuplicatesFromSortedArray" to P26RemoveDuplicatesFromSortedArray,
    "removeElement" to P27RemoveElement,
    "findIndexOfFirstOccurrence" to P28FindIndexOfFirstOccurrence,
    "searchInsert" to P35SearchInsert,
    "lengthOfLastWord" to P58LengthOfLastWord,
    "plusOne" to P66PlusOne,
    "addBinary" to P67AddBinary,
    "sqrtx" to P69Sqrtx,
    "removeDuplicatesFromSortedList" to P83RemoveDuplicatesFromSortedList,
    "mergeSortedArray" to P88MergeSortedArray,
    "sameTree" to P100SameTree,
    "symmetricTree" to P101SymmetricTree,
    "convertSortedArrayToBinarySearchTree" to P108ConvertSortedArrayToBinarySearchTree,
    "pascalsTriangle" to P118PascalsTriangle,
    "validPalindrome" to P125ValidPalindrome,
    "majorityElement" to P169MajorityElement,
    "reverseLinkedList" to P206ReverseLinkedList,
    "containsDuplicate" to P217ContainsDuplicate,
    "backspaceStringCompare" to P844BackspaceStringCompare,
    "antOnTheBoundary" to P3028AntOnTheBoundary,

    // medium
    "addTwoNumbers" to P2AddTwoNumbers,
    "longestSubstringWithoutRepeatingChars" to P3LongestSubstringWithoutRepeatingChars,
    "zigZagConversion" to P6ZigZagConversion,
    "reverseInteger" to P7ReverseInteger,
    "stringToInteger" to P8StringToInteger,
    "containerWithMostWater" to P11ContainerWithMostWater,
    "integerToRoman" to P12IntegerToRoman,
    "3Sum" to P15ThreeSum,
    "letterCombinationsOfAPhoneNumber" to P17LetterCombinationsOfAPhoneNumber,
    "removeNthNodeFromEnd" to P19RemoveNthNodeFromEnd,
    "generateParentheses" to P22GenerateParentheses,
    "swapNodesInPairs" to P24SwapNodesInPairs,
    "nextPermutation" to P31NextPermutation,
    "searchInRotatedSortedArray" to P33SearchInRotatedSortedArray,
    "findFirstLastPositionOfElementInSortedArray" to P34FindFirstLastPositionOfElementInSortedArray,
    "validSudoku" to P36ValidSudoku,
    "combinationSum" to P39CombinationSum,
    "jumpGame2" to P45JumpGame2,
    "permutations" to P46Permutations,
    "rotateImage" to P48RotateImage,
    "groupAnagrams" to P49GroupAnagrams,
    "powXN" to P50PowXN,
    "maximumSubarray" to P53MaximumSubarray,
    "spiralMatrix" to P54SpiralMatrix,
    "insertInterval" to P57InsertInterval,
    "rotateList" to P61RotateList,
    "uniquePaths" to P63UniquePaths,
    "minPathSum" to P64MinPathSum,
    "simplifyPath" to P71SimplifyPath,
    "searchA2DMatrix" to P74SearchA2DMatrix,
    "sortColors" to P75SortColors,
    "combinations" to P77Combinations,
    "wordSearch" to P79WordSearch,
    "removeDuplicatesFromSortedArrayII" to P80RemoveDuplicatesFromSortedArrayII,
    "longestConsecutiveSequence" to P128LongestConsecutiveSequence,
    "evaluateReversePolishNotation" to P150EvaluateReversePolishNotation,
    "minStack" to P155MinStack,
    "numberOfIslands" to P200NumberOfIslands,
    "countPrimes" to P204CountPrimes,
    "productOfArrayExceptSelf" to P238ProductOfArrayExceptSelf,
    "validAnagram" to P242ValidAnagram,
    "topKFrequentElements" to P347TopKFrequentElements,
    "dailyTemperatures" to P739DailyTemperatures,
    "rangeSumOfSortedSubarraySums" to P1508RangeSumOfSortedSubarraySums,

    // hard
    "medianOfTwoSortedArrays" to P4MedianOfTwoSortedArrays,
    "regularExpressionMatching" to P10RegularExpressionMatching,
    "mergeKSortedLists" to P23MergeKSortedLists,
    "reverseNodesInKGroup" to P25ReverseNodesInKGroup,
    "substringWithConcatOfAllWords" to P30SubstringWithConcatOfAllWords,
    "longestValidParentheses" to P32LongestValidParentheses,
    "sudokuSolver" to P37SudokuSolver,
    "firstMissingPositive" to P41FirstMissingPositive,
    "trappingRainWater" to P42TrappingRainWater,
    "wildcardMatching" to P44WildcardMatching,
    "nQueens" to P51NQueens,
    "validNumber" to P65ValidNumber,
    "textJustification" to P68TextJustification,
    "minimumWindowSubstring" to P76MinimumWindowSubstring,
    "largestRectangle" to P84LargestRectangle,
    "binaryTreeMaxPathSum" to P124BinaryTreeMaximumPathSum,

    // random
    "wordMap" to WordMap,
)

fun main(args: Array<String>) {
    require(args.isNotEmpty()) { "Specify the solution name" }

    val solution = args[0]
    solutions[solution]?.test() ?: println("Solution '$solution' not found")
}
