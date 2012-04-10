/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), 
a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve 
this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it 
would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)


Strategy:
going from bottom to top, changing the nodes so that they containt sum of their previous value 
and the value of a larger child
*/

import java.lang.Math

def triangle = new File('triangle.txt')
def tree = []

triangle.eachLine {
    def line = it.tokenize()
    def row = []
    line.each { n->
        row << n.toInteger()
    }
    tree << row
}

Integer maxSum(tree) {
    def depth = tree.size()-1
    (depth..1).each {ix ->
        (0..ix-1).each {iy ->
            tree[ix-1][iy]+=Math.max(tree[ix][iy], tree[ix][iy+1]) 
        }
    }
    tree[0][0]
}

def start = System.nanoTime()
def result = maxSum(tree)
def stop = System.nanoTime()
println "Result: " + result
println "Time taken: " + (stop - start)/1e9