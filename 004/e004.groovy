/*
A palindromic number reads the same both ways.
The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/
import groovy.time.*

boolean isPalindrome(number) {
    String numberStr = number.toString()
    Integer numberLength = numberStr.size()
    for (i in (0..(numberLength/2 as Integer))) {
        if (numberStr[i] != numberStr[numberLength-i-1])
            return false
    }
    return true
}

Integer findLargest() {
    def largest = 0
    for (i in (999..100)) {
        for (j in (i..100)) {
            def product = i*j
            if ((product > largest) && isPalindrome(product))
                largest = product
        }
    }
    largest
}

def timeStart = new Date()
println "Result: " + findLargest()
def timeStop = new Date()
println "Time taken: " + TimeCategory.minus(timeStop, timeStart)