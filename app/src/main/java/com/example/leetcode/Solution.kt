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
    val shuffleNums = intArrayOf(2, 5, 1, 3, 4, 7)
    val shuffleTarget = 3
    val target = 6

    println("Two Sums: " + sol.twoSum(nums, target))
    println("Build Array: " + buildArray(buildNums).contentToString())
    println("Increasing Array: " + improvedRunningSums(increasingNums).contentToString())
    println("Shuffling: " + shuffle(shuffleNums, shuffleTarget).contentToString())
    println(
        "Shuffling w/ Imporvement: " + shuffleImprove(
            shuffleNums,
            shuffleTarget
        ).contentToString()
    )

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

/*
There is a programming language with only four operations and one variable X:
    ++X and X++ increments the value of the variable X by 1.
    --X and X-- decrements the value of the variable X by 1.
Initially, the value of X is 0.
Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 */
fun finalValueAfterOperations(operations: Array<String>): Int {
    var x = 0
    loop@ for (word in operations) {
        when (word) {
            "++X" -> ++x
            "X++" -> x++
            "--X" -> --x
            "X--" -> x--
            else -> {
                println("Invalid input")
                x = 0
                break@loop
            }
        }
    }
    return x
}

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */
fun shuffle(nums: IntArray, n: Int): IntArray {
    val arr = IntArray(nums.size)
    for (i in nums.indices) { //can also do 2 variables and increment with j pointing to n
        if (i % 2 == 0) {
            arr[i] = nums[i / 2]
        } else {
            arr[i] = nums[n + i / 2]
        }
    }
    return arr
}

fun shuffleImprove(nums: IntArray, n: Int): IntArray {
    val arr = mutableListOf<Int>()
    for (i in 0 until n) {
        arr.add(nums[i])
        arr.add(nums[i + n])
    }
    return arr.toIntArray()
}
