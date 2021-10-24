package com.example.leetcode

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (index in nums.indices) {
            for (index2 in index + 1 until nums.size) {
                if (nums[index] + nums[index2] == target) {
                    return intArrayOf(index, index2)
                }
            }
        }
        return IntArray(0)
    }
}

fun main() {
    val sol: Solution = Solution()
    val nums = intArrayOf(2, 0, 4, 3, 1)
    val buildNums = intArrayOf(0, 2, 1, 5, 3, 4)
    val increasingNums = intArrayOf(1, 2, 3, 4, 5)
    val target = 6

    println("Two Sums: " + sol.twoSum(nums, target))
    println("Build Array: " + buildArray(buildNums).contentToString())
    println("Increasing Array: " + improvedRunningSums(increasingNums).contentToString())

}

//Better Solution
fun twoSum(nums: IntArray, target: Int): IntArray {

    val indexedList = nums.withIndex().toList()
    indexedList.forEach { (indexA, valueA) ->
        val subList = indexedList.subList(indexA + 1, nums.size)
        subList.forEach { (indexB, valueB) ->
            if (valueA + valueB == target) {
                return intArrayOf(indexA, indexB)
            }
        }
    }

    return intArrayOf()
}

fun buildArray(nums: IntArray): IntArray {
    var arr: IntArray = IntArray(nums.size)
    for (num in nums) {
        arr[num] = nums[nums[num]]
    }
    return arr
}

fun runningSum(nums: IntArray): IntArray {
    val results = IntArray(nums.size)
    var runningTotal = 0
    for (i in 0..nums.size - 1) {
        results[i] = runningTotal + nums[i]
        runningTotal = results[i]
    }
    return results
}

fun improvedRunningSums(nums: IntArray): IntArray {
    for (i in 1 until nums.size) {
        nums[i] = nums[i] + nums[i - 1]
    }
    return nums;
}