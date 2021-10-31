package com.example.leetcode

import java.util.*
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

fun main() {
    val stringToPassForUniq = "leetcode"
    val stringForFrequency = "tree"
    println("First Uniq Char of string: $stringToPassForUniq is: ${firstUniqChar(stringToPassForUniq)}")
    println("Frequency sort string: $stringForFrequency is: ${frequencySort(stringForFrequency)}")

}