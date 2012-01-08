/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/
import java.lang.Math
import groovy.time.*

boolean isPrime(number) { 
    Integer limit = Math.sqrt(number)
    for (i in (2..limit)) {
        if (number%i == 0) {
            return false
        }
    }
    
    return true
}

boolean isDivisor(number) {
    if (600851475143%number == 0) {
        return true
    }
    return false
}


def timeStart = new Date()
Integer limit = Math.sqrt(600851475143)
Integer i = limit
while (i > 1) {
    if (isPrime(i) && isDivisor(i)) {
        println "Solution: " + i
        break
    }
    i--
}

def timeStop = new Date()
println "Time taken: " + TimeCategory.minus(timeStop, timeStart)