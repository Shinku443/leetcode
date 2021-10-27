package com.example.leetcode;

public class MinStack() {
    private var elements: MutableList<Int> = mutableListOf()

    fun push(`val`: Int) {
        elements.add(`val`)
    }

    fun pop() {
        elements.removeAt(elements.lastIndex)
    }

    fun top(): Int {
        return elements.last()
    }

    fun getMin(): Int {
        return elements.minOrNull()!!
    }

}

fun main() {
    var obj = MinStack()
    obj.push(3)
    obj.push(-1)
    obj.push(-5)
    obj.pop()
    var param_3 = obj.top()
    var param_4 = obj.getMin()
    println(param_3)
    println(param_4)
}