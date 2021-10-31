package com.example.leetcode

class TreeSolutions {


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    //TODO COME BACK TO THIS
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` == null && q?.`val` == null) {
            return true
        }
        if (p?.`val` != null && q?.`val` == null) {
            return false
        }//these can be reduced to just p == null || q == null
        if (q?.`val` != null && p?.`val` == null) {
            return false
        }
        if (p?.`val` != q?.`val`) {
            return false
        }
        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

    fun isSameTreeImproved(p: TreeNode?, q: TreeNode?): Boolean {
        if (p === q) return true
        if (p?.`val` != q?.`val`) return false
        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

    //TODO - COMEBACK FOR THIS TOO
    fun invertTree(root: TreeNode?): TreeNode? {
        // println("NEW INVERSION root: ${root?.`val`}")
        if (root == null) {
            //   println("root is null")
            return null
        }
        invertTree(root.left)
        invertTree(root.right)
        var tmp: TreeNode? = root.left
        root.left = root.right
        root.right = tmp

        return root
    }

    /// TODO - Just go over all the tree stuff man
    fun treeTravelHelper(root: TreeNode?, list: MutableList<Int>): MutableList<Int> {
        if (root?.left != null) {
            treeTravelHelper(root.left, list)
        }
        list.add(root!!.`val`)
        if (root?.right != null) {
            treeTravelHelper(root.right, list)
        }

        return list
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val travel: MutableList<Int> = mutableListOf()
        treeTravelHelper(root, travel)
        return travel
    }

    fun main(){
        //Tree Area
        val pTree = TreeNode(1)
        pTree.left = TreeNode(2)
        //pTree.right = TreeNode(3)
        pTree.right = null
        val qTree = TreeNode(1)
        qTree.left = TreeNode(2)
        //qTree.right = TreeNode(3)
        qTree.right = null
        //Invert Tree
        val invertingTree = TreeNode(4)
        val invertLeft = TreeNode(2)
        invertingTree.left = invertLeft
        invertLeft.left = TreeNode(1)
        invertLeft.right = TreeNode(3)
        val invertRight = TreeNode(7)
        invertingTree.right = invertRight
        invertRight.left = TreeNode(6)
        invertRight.right = TreeNode(9)

        println("Is Same Tree: ${isSameTree(pTree, qTree)}")

        println("Is Same Tree Improved: ${isSameTreeImproved(pTree, qTree)}")
        println("Inverting Tree: ${invertTree(invertingTree)?.`val`}")
        println("Traversing Tree: ${inorderTraversal(invertingTree)}")
    }
}