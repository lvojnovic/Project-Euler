/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/
import groovy.time.*

def startTime = System.nanoTime()
Long number = 600851475143
def lastFactor
def iterator = 2
while (number > 1) {
    if (number%iterator == 0) {
        lastFactor = iterator
        number/=iterator
    } else {
        iterator ++
    }
}

println "Result: " + lastFactor
def stopTime = System.nanoTime()
println "Time taken: " + (stopTime - startTime)/1e9
