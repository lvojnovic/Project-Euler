/*
The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 552 = 3025

Hence the difference between the sum of the squares of the first 
ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first 
one hundred natural numbers and the square of the sum.
*/

import java.lang.Math

//1.
//(x+y+...+z)^2 - (x^2 + y^2 + ... + z^2) = 2xy + 2yz + ... + 2xz

def start = System.nanoTime()
def result = 0
for (i in 1..100) {
    for (j in i..100) {
        if (i != j) {
            result += 2*i*j
        }
    }
}

def stop = System.nanoTime()
println "Direct approach"
println "Result: " + result
println "Total time:" + (stop-start)/1e9

//2.
//Using formulas:
//1+2+3+...+n=n*(n+1)/2
//1^2+2^2+...+n^2=n*(n+1)*(2*n+1)/6 

start = System.nanoTime()
result = (Math.pow(100*(100+1)/2, 2) - 100*(100+1)*(2*100+1)/6) as Integer
stop = System.nanoTime()
println "Math approach"
println "Result: " + result
println "Total time:" + (stop-start)/1e9