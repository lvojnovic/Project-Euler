/*
Let d(n) be defined as the sum of proper divisors of n 
(numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b 
are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 
1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

Solution: http://planetmath.org/FormulaForSumOfDivisors.html
*/

import java.lang.Math

def isPrime = { Integer n ->
    if (n == 1) {
        return false
    } else if (n < 4) { //2, 3
        return true
    } else if (n % 2 == 0) { //4,6,8
        return false
    } else if (n < 9) {//5,7
        return true
    } else if (n % 3 == 0) {//9
        return false
    } else {
        Integer root = Math.sqrt(n)
        //every prime > 3 is of form 6*n-1 or 6*n+1
        
        def p = 5
        while (p <= root) {
            if (n%p == 0) {
                return false
            }
            if (n%(p+2) == 0) {
                return false
            }
            p+=6
        }
    }
    true
}

def primesList = { Integer size ->
    def prime = 2
    def count = 0
    def primeNumbers = []
    while (count < size) {
        if (isPrime(prime)) {
            primeNumbers.push(prime)
            count++
        }
        prime++
    }
    primeNumbers
}

def divisorSum = { List primeNumbers, Integer n ->
    def sumOfProper = 1
    def unproperSum = 1
    def iterator = 0
    Integer number = n
    while (iterator< primeNumbers.size()) {
        if (number%primeNumbers[iterator]==0) {
            def exponent = 1
            number/=primeNumbers[iterator]
            while (number%primeNumbers[iterator] == 0) {
                number/=primeNumbers[iterator]
                exponent++
            }
            sumOfProper*=(Math.pow(primeNumbers[iterator], exponent+1) - 1)/(primeNumbers[iterator] - 1)
            unproperSum*=(Math.pow(primeNumbers[iterator], exponent))
        }
        if (number == 1) break
        
        iterator++
    }
    
    (sumOfProper - unproperSum) as Integer
}

HashSet amicableNumbers = []
def primes = primesList(2000)
(2..10000).each {
    if (amicableNumbers.contains(it)) return

    def DSum = divisorSum(primes, it)
    if (DSum != 1 && DSum != it && divisorSum(primes, DSum) == it) {
        amicableNumbers.add(it)
        amicableNumbers.add(DSum)
    }
}

amicableNumbers.sum()