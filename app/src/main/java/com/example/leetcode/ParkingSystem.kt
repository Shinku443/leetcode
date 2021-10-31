package com.example.leetcode

/**
 *
 * ParkingSystem(int big, int medium, int small)
 * Initializes object of the ParkingSystem class.
 * The number of slots for each parking space
 * are given as part of the constructor.
 * bool addCar(int carType)
 * Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
 * carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
 * A car can only park in a parking space of its carType. If there is no space available,
 * return false, else park the car in that size space and return true.
 */
class ParkingSystem(var big: Int, var medium: Int, var small: Int) {
    /*var big = big
    var medium = medium
    var small = small*/

    fun addCar(carType: Int): Boolean {
        when (carType) {
            1 -> {
                if (big > 0) {
                    big--
                    return true
                }
            }
            2 -> {
                if (medium > 0) {
                    medium--
                    return true
                }
            }

            3 -> {
                if (small > 0) {
                    small--
                    return true
                }
            }
            else -> return false
        }
        return false
    }

    //Simplified
    fun addCarImproved(carType: Int): Boolean {
        return when (carType) {
            1 -> big-- > 0
            2 -> medium-- > 0
            3 -> small-- > 0
            else -> false
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */