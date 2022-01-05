package com.example.leetcode

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.get as get1

class StringSolutions {

}

/**
 * 387. First Unique Character in a String
 * Given a string s,
 * find the first non-repeating character
 * in it and return its index.
 * If it does not exist, return -1.
 */
fun firstUniqChar(s: String): Int {
    val hashMap = hashMapOf<Char, Int>()
    val hashMapIndex = hashMapOf<Char, Int>()
    for ((index, ch) in s.withIndex()) {
        if (!hashMap.containsKey(ch)) {
            hashMap[ch] = 1
            hashMapIndex[ch] = index
        } else {
            var count = hashMap[ch]!!
            hashMap[ch] = ++count
        }
    }

    var lowestIndex = Int.MAX_VALUE
    for (hashVal in hashMap.keys) {
        if (hashMap[hashVal] == 1) {
            if (hashMapIndex[hashVal]!! < lowestIndex)
                lowestIndex = hashMapIndex[hashVal]!!
            //return hashMap[hashVal]!!
        }
    }
    if (lowestIndex == Int.MAX_VALUE) {
        return -1
    }
    return lowestIndex
}

/**
 * MEDIUM
 * 451. Sort Characters By Frequency
 */
fun frequencySort(s: String): String { //Prio Queue does ordering
    val hashMap = HashMap<Char, Int>()
    s.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    val priorityQueue =
        PriorityQueue<Char> { n1, n2 -> hashMap[n2]!! - hashMap[n1]!! } //sorting order
    hashMap.keys.forEach {
        priorityQueue.add(it)
    }
    val stringBuilder: StringBuilder = StringBuilder()
    while (!priorityQueue.isEmpty()) {
        val char = priorityQueue.remove()
        val count = hashMap[char] ?: 0
        for (i in 0 until count) {
            stringBuilder.append(char)
        }
    }
    return stringBuilder.toString()
}

fun frequencySortImproved(s: String): String {
    return s.groupBy { it }
        .map { it.key to it.value.size }
        .sortedWith(compareByDescending<Pair<Char, Int>> { it.second }.thenByDescending { it.first })
        .joinToString("") { it.first.toString().repeat(it.second) }
}

/**
 * MEDIUM
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 * You may return the answer in any order.
 */
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    nums.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    val priorityQueue =
        PriorityQueue<Int> { n1, n2 -> hashMap[n2]!! - hashMap[n1]!! } //sorting order
    hashMap.keys.forEach {
        priorityQueue.add(it)
    }
    var counter = k
    var index = 0
    val arrayToReturn = IntArray(k)
    while (!priorityQueue.isEmpty() && counter > 0) {
        arrayToReturn[index++] = priorityQueue.remove()
        counter--
    }
    return arrayToReturn
}

/**
 * MEDIUM
 * 215. Kth Largest Element in an Array
 */
fun findKthLargest(nums: IntArray, k: Int): Int {
    val hashMap = HashMap<Int, Int>()
    nums.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    val priorityQueue =
        PriorityQueue<Int>(Collections.reverseOrder()) //sorting order
    hashMap.keys.forEach {
        priorityQueue.add(it)
    }
    var ele = -1
    val list: ArrayList<Int> = ArrayList(nums.size)
    while (!priorityQueue.isEmpty()) {
        val num = priorityQueue.remove()
        val count = hashMap[num] ?: 0
        for (i in 0 until count) {
            list.add(num)
        }
    }
    println("List: $list")
    for (i in 0 until k) {
        ele = list[i]
    }
    return ele
}

/**
 * EASY
 * 1636. Sort Array by Increasing Frequency
 */
fun frequencySort(nums: IntArray): IntArray {
    val hashMap = HashMap<Int, Int>()
    nums.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    hashMap.toSortedMap()
    var index = 0
    val arrayToReturn = IntArray(nums.size)

    return arrayToReturn
}

/**
 * 1805. Number of Different Integers in a String
 */
fun numDifferentIntegers(word: String): Int {
    var count = 0
    var foundDig = false
    var map: HashMap<String, Int> = HashMap<String, Int>()
    var newString: StringBuilder = StringBuilder()
    val result = buildString {
        word.forEach {
            println("dig:: $it")
            if (it.isDigit()) {
                foundDig = true
                append(it)
                append(' ')
            } else {
                foundDig = false

            }
        }
    }
    println("Result: $result")
    return count
}

/**
 *Stop gninnipS My sdroW!
 */
fun spinWords(sentence: String): String {
    var tmp = sentence.split(' ').toMutableList()

    for (i in tmp.indices) {
        if(tmp[i].length >= 5 ) {
            tmp[i] = tmp[i].reversed()
        }
        println("i:: $i and val: $i")
    }
    return tmp.joinToString(" ")
}
fun main() {
    println("Spin words: ${spinWords("Hey fellow warriors")}")
    val stringToPassForUniq = "leetcode"
    val stringForFrequency = "tree"
    val stringForDiffIntegers = "a123bc34d8ef34"
    val intArrayForFreq = intArrayOf(1, 1, 1, 2, 2, 3)
    val intArrayForKth = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    val freqNum = 2
    val freqNumForK = 4
    println(
        "First Uniq Char of string: $stringToPassForUniq is: ${
            firstUniqChar(
                stringToPassForUniq
            )
        }"
    )
    println("Frequency sort string: $stringForFrequency is: ${frequencySort(stringForFrequency)}")
    println(
        "Frequency of frequency to check: $freqNum is: ${
            topKFrequent(
                intArrayForFreq,
                freqNum
            )
        }"
    )

    println(
        "Finding kth: $freqNumForK of: ${
            findKthLargest(
                intArrayForKth,
                freqNumForK
            )
        }"
    )

    println("Frequency sort: ${frequencySort(intArrayForFreq).contentToString()}")

    println(
        "Number of different integers in string: $stringForDiffIntegers : ${
            numDifferentIntegers(
                stringForDiffIntegers
            )
        }"
    )

}