/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

import java.lang.Math

boolean isPrime(n) {
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

def start = System.nanoTime()
def sum = 0.00
(1..2000000).each { n ->
    if (isPrime(n)) {
        sum+=n
    }
}

def stop = System.nanoTime()
println "Result: " + sum
println "Time taken: " + (stop - start)/1e9