/*
A perfect number is a number for which the sum of its proper divisors 
is exactly equal to the number. For example, the sum of the proper 
divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 
is a perfect number.

A number n is called deficient if the sum of its proper divisors is 
less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the 
smallest number that can be written as the sum of two abundant 
numbers is 24. By mathematical analysis, it can be shown that 
all integers greater than 28123 can be written as the sum of 
two abundant numbers. However, this upper limit cannot be 
reduced any further by analysis even though it is known that 
the greatest number that cannot be expressed as the sum of 
two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be 
written as the sum of two abundant numbers.

*/

import java.lang.Math

def getProperDivisors = { Integer number ->
    def divisors = [1]
    
    def numSqrt = Math.sqrt(number)
    for (divisor in (2..numSqrt)) {
        if (number % divisor == 0) {
            divisors.push(divisor)
            divisors.push(number/divisor)
        }
    }
    
    divisors.unique()
}

def isAbundant = { Integer i ->
    def divisors = getProperDivisors(i)

    if (divisors.sum() > i) return true
    
    return false
}

def startTime = System.nanoTime()
def abundantNumbers = []
for (iterator in (3..28128)) {
    if (isAbundant(iterator)) abundantNumbers.push(iterator)
}

def sumOfAbundant = [:]
def abundantNumbersLength = abundantNumbers.size()
for ( i in (0..abundantNumbersLength-1)) {
    for ( j in (i..abundantNumbersLength-1)) {
        sumOfAbundant[abundantNumbers[i] + abundantNumbers[j]] = true
    }
}

def sum = 0
for (iterator in (1..28123)) {
    if (!sumOfAbundant[iterator]) sum+=iterator
}

def stopTime = System.nanoTime()
println "Time taken: " + (stopTime-startTime)/1e9
sum