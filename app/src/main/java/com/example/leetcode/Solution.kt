package com.example.leetcode

class Solution {
    fun test() {

    }
}

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


//Better Solution
fun twoSumBetter(nums: IntArray, target: Int): IntArray {

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


fun numIdenticalPairs(nums: IntArray): Int {
    var result = 0
    for (i in nums.indices) {
        for (j in nums.indices) {
            if (nums[i] == nums[j] && i < j) {
                result++

            }
        }
    }
    return result
}

/**
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 *
 * [0,1,2,2,3,0,4,2], val = 2
 * TODO - REVISIT THIS
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
    var found = 0
    for (i in nums.indices) {
        if (`val` != nums[i]) {
            nums[found] = nums[i]
            //first 'found' elements should be the result
            found++
        }
    }
    return found
}

/*
fun permute(nums: IntArray): List<List<Int>> {

}*/

/**
 * TWO SUM PART 2 ----
 *   fun twoSum(numbers: IntArray, target: Int): IntArray {

var left = 0
var right = numbers.size - 1

while (left <= right) {
var sum = numbers[left] + numbers[right]

if (sum > target) right--
else if (sum < target) left++
else
return intArrayOf(left + 1, right + 1)
}

return intArrayOf(left + 1, right + 1)
}
 */

fun isPalindrome(x: Int): Boolean {
    return true
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var newList: ListNode? = ListNode(0)
    var tail = newList
    var node1 = l1
    var node2 = l2
    while (node1 != null || node2 != null) {
        if (node1 == null) {
            tail?.next = node2; break
        }
        if (node2 == null) {
            tail?.next = node1; break
        }
        if (node1.`val` < node2.`val`) {
            tail?.next = node1
            node1 = node1?.next
        } else {
            tail?.next = node2
            node2 = node2?.next
        }
        tail = tail?.next
    }
    return newList?.next
}

//Find element more than n / 2 times
fun majorityElement(nums: IntArray): Int {
    var count: HashMap<Int, Int> = hashMapOf()
    for (num in nums) {
        if (count.get(num) == null) {
            count.put(num, 1)
        } else {
            var countOfInstance = count.get(num)!! + 1
            count.put(num, countOfInstance)
        }
    }
    var max: Int = -1
    var keyFound = -1

    for (num in count) {
        if (num.value > max) {
            keyFound = num.key
            max = num.value
        }
    }
    return keyFound

}

fun singleNumber(nums: IntArray): Int {
    var count: HashMap<Int, Int> = hashMapOf()
    for (num in nums) {
        if (count.get(num) == null) {
            count.put(num, 1)
        } else {//faster optimization - remove and then just check for key
            var countOfInstance = count.get(num)!! + 1
            count.put(num, countOfInstance)
        }
    }
    for (num in count) {
        if (num.value == 1) {
            return num.key
        }
    }
    return -1
}

/**
 * 121. Best Time to Buy and Sell Stock
 */
fun maxProfit(prices: IntArray): Int {

    var maxProfit = 0
    for (i in 0.until(prices.size)) {
        //println("----Buying Price: on day $i with $$buyPrice----")
        for (j in i.until(prices.size)) {
            //println("Price of next days: ==$j with $${prices[j]}==")
            var profit = prices[j] - prices[i]
            //println("Potential Pricing: $$tmpVal")
            if (profit > 0 && profit > maxProfit) {
                maxProfit = profit;
                //    println("ITS BEING REPLACED!!!!::::: $$profit")
            }
        }
    }
    return maxProfit
}
//Make this better

fun maxProfitImproved(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE
    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice
        }
    }
    return maxProfit

}

/**
 * 217. Contains Duplicate
 * Given an integer array nums,
 * return true if any value appears
 * at least twice in the array, and
 * return false if every element is distinct.
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val map: HashMap<Int, Int> = hashMapOf()
    for (num in nums) {
        if (map.containsKey(num)) {
            return true
        }
        map[num] = 1
    }
    return false
}

/**
 * 205. Isomorphic Strings
 * Two strings s and t are isomorphic
 * if the characters in s can be replaced to get t.
 * All occurrences of a character must
 * be replaced with another character while
 * preserving the order of characters.
 * No two characters may map to the same character,
 * but a character may map to itself.
 */
fun isIsomorphic(s: String, t: String): Boolean {
    val mapStringOneToStringTwo = hashMapOf<Char, Char>()
    val mapStringTwoToStringOne = hashMapOf<Char, Char>()
    for (i in s.indices) {
        if (!mapStringOneToStringTwo.containsKey(s[i]) && !mapStringTwoToStringOne.containsKey(t[i])) {
            mapStringOneToStringTwo[s[i]] = t[i]
            mapStringTwoToStringOne[t[i]] = s[i]
        } else {
            if (mapStringOneToStringTwo[s[i]] != t[i] || mapStringTwoToStringOne[t[i]] != s[i]) {
                return false
            }
        }
    }

    return true
}

/**
 * 202. Happy Number
 */
fun isHappy(n: Int): Boolean {
    var num = n
    //n = 19
    //n[0]*n[0] + n[1] + n[1]
    var seen: MutableSet<Int> = HashSet()
    while (num !== 1 && !seen.contains(num)) {
        seen.add(num)
        println("NUM::::$num")
        //  num = getNext(num)

    }
    return num === 1
}

fun getNext(n: Int): Int {
    var totalSum = 0
    var num = n
    while (num > 0) {
        val d = n % 10
        println("digit: $d")
        num = n / 10
        println("num? $num")
        totalSum += d * d
    }
    return totalSum
}

/**
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * Example 2:
 */
fun subtractProductAndSum(n: Int): Int {
    var product = 1
    var sum = 0
    //var num = n
    var temp = n
    println("Num : $n")
    while (temp > 0) {
        println("Now num is : $temp")
        println("Mod.... : ${temp % 10}")
        product *= temp % 10
        sum += temp % 10
        temp /= 10
    }
    return product - sum

}

/**
 * 1528. Shuffle String
 */
fun restoreString(s: String, indices: IntArray): String {
    val sb = StringBuilder(s)
    println("taking : ${sb.toString()} with indices: ${indices.toString()}")
    for ((index, i) in indices.withIndex()) {
        println("index: $index and i: $i")
        //println("I: $i : ${s[i]} vs ${s[index]}")
        sb.setCharAt(i, s[index])
        //newString[i] = s[i]
    }
    return sb.toString()
}

/**
------ STARTING STUDY PLAN ALGO 1 ------
 */

/**
 * 704. Binary Search
 */
fun search(nums: IntArray, target: Int): Int {
    for (num in nums.withIndex()) {
        if (num.value == target) {
            return num.index
        }
    }
    return -1
}

/**
 * 278. First Bad Version
 */
fun firstBadVersion(n: Int): Int {
    return binarySearchTree(0, n)
}


fun binarySearchTree(lower: Int, upper: Int): Int {
    val mid = lower + ((upper - lower) / 2)
    val isBad = false//isBadVersion(mid.toInt())
    if (lower >= upper) return upper //we've exhausted it all so we're at the top

    return if (isBad)
        binarySearchTree(lower, mid)
    else
        binarySearchTree(mid + 1, upper)
}


/**
 * 35. Search Insert Position
 */

fun searchInsert(nums: IntArray, target: Int): Int {
    for ((index, value) in nums.withIndex()) { //iterate through
        if (value >= target) return index //if we find the target return index
    }
    return nums.size
    //kotlin cheat - return nums.binarySearch(target)
}

/**
 * 977. Squares of a Sorted Array - supposed to be
 * two pointers so we make it like that
 */
fun sortedSquares(nums: IntArray): IntArray {
var newArray = IntArray(nums.size)
    for(num in nums.withIndex()){
        newArray[num.index] = num.value * num.value
    }
    return newArray.sortedArray()
}

fun sortedSquaresWithTwoPointers(nums:IntArray): IntArray {
    var result = IntArray(nums.size)
    var start = 0
    var end = nums.size-1
    for(i in nums.size -1 downTo 0){
        if (kotlin.math.abs(nums[start]) > kotlin.math.abs(nums[end])) {
            result[i] = nums[start] * nums[start]
            start++
        } else {
            result[i] = nums[end] * nums[end]
            end--
        }
    }
return result

}

/**
 * 26. Remove Duplicates from Sorted Array
 */
fun removeDuplicates(nums: IntArray): Int {
    var found = hashMapOf<Int, Int>()
    for(i in nums.indices){
        if(found[i]!! > 0){
            found[i] = found[i]!! + 1
        }else{
            found[i] = 1
            nums[i] = nums[i]
        }
    }
    return -1
}

fun main() {
    /**
     * All Variables
     */
    val nums = intArrayOf(2, 0, 4, 3, 1)
    val buildNums = intArrayOf(0, 2, 1, 5, 3, 4)
    val increasingNums = intArrayOf(1, 2, 3, 4, 5)
    val shuffleNums = intArrayOf(2, 5, 1, 3, 4, 7)
    val goodPairNums = intArrayOf(1, 2, 3, 1, 1, 3)
    val removalNums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    val buyPrices = intArrayOf(7, 1, 5, 3, 6, 4)
    val buyPricesTwo = intArrayOf(7, 6, 4, 3, 1)
    val binarySearchNums = intArrayOf(-1, 0, 3, 5, 9, 12)
    val removalTarget = 2
    val shuffleTarget = 3
    val target = 6
    val isoStringOne = "egg"
    val isoStringTwo = "add"
    val shuffleString = "codeleet"
    val shuffleStringIndex = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)

    val majorityElementNums = intArrayOf(3, 3, 4)

    val happyNum = 19
    val digitsOfIntNum = 234
    val binarySearchNumTarget = 9

    val listOne: ListNode? = ListNode(1)
    listOne?.next = ListNode(2)
    listOne?.next?.next = ListNode(4)

    val listTwo: ListNode? = ListNode(1)
    listTwo?.next = ListNode(3)
    listTwo?.next?.next = ListNode(4)
    /**
     * Printing Out Functions
     */
    println("Two Sums: " + twoSum(nums, target))
    println("Build Array: " + buildArray(buildNums).contentToString())
    println("Increasing Array: " + improvedRunningSums(increasingNums).contentToString())
    println("Shuffling: " + shuffle(shuffleNums, shuffleTarget).contentToString())
    println(
        "Shuffling w/ Imporvement: " + shuffleImprove(
            shuffleNums,
            shuffleTarget
        ).contentToString()
    )

    println("Numbering Identical Pairs: ${numIdenticalPairs(goodPairNums)}")

    println("Removing Numbers: ${removeElement(removalNums, removalTarget)}")


    var nodes: ListNode? = mergeTwoLists(listOne, listTwo)
    println("Merging list::")
    for (n in 0 until 6) {
        println("Order:: ${nodes?.`val`}")
        nodes = nodes?.next
    }

    println("Majority Element: ${majorityElement(majorityElementNums)}")
    println("Max Profit: ${maxProfit(buyPrices)}")
    println("------SEPARATING------\n\n\n")
    println("Max Profit (Not valid): ${maxProfit(buyPricesTwo)}")
    println("------IMPROVING------\n\n\n")
    println("Max Profit: ${maxProfitImproved(buyPrices)}")
    println("------SEPARATING------\n\n\n")
    println("Max Profit (Not valid): ${maxProfitImproved(buyPricesTwo)}")

    println(
        "Are the strings $isoStringOne and $isoStringTwo isomorphic? : ${
            isIsomorphic(
                isoStringOne,
                isoStringTwo
            )
        }"
    )

    println("Is this number $happyNum a happy num? :: ${isHappy(happyNum)}")

    println(
        "Subtracting product and sum of digits of n: $digitsOfIntNum :: ${
            subtractProductAndSum(
                digitsOfIntNum
            )
        }"
    )

    println(
        "Shuffling string: $shuffleString -> ${
            restoreString(
                shuffleString,
                shuffleStringIndex
            )
        }"
    )

    println("Binary search: ${search(binarySearchNums, binarySearchNumTarget)}")
}

