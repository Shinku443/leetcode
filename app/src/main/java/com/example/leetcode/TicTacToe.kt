package com.example.leetcode

import android.graphics.Point
//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/discuss/446227/Kotlin-93.3-and-100-TicTacToe
class TicTacToe {

    /**
     * 1275. Find Winner on a Tic Tac Toe Game
     */
    fun tictactoe(moves: Array<IntArray>): String {

        val playerA: MutableSet<Point> = HashSet(moves.size / 2)
        val playerB: MutableSet<Point> = HashSet(moves.size / 2)
//Evens == A - Odds = B

        return ""
    }

    fun hasWinViaRowsOrColumns(points: Set<Point>): Boolean {
        //Check Across
        //0,0 0,1 0,2
        //1,0 1,1 1,2
        //2,0 2,1 2,2
        /*for(move in moves) {
            if (moves.get())
            //Check Diag
            else if
            //Check Vertical
            else if
        }*/
        return false;
    }

    fun checkDiag(points: Set<Point>): Boolean{
        return false;
    }

    fun isBoardFull(moves: Array<IntArray>): Boolean {
        return moves.size == 9
    }
}