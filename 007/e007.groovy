/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
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
def primeCount = 1 //2
def n = 1 //init
while(primeCount < 10001) {
    n +=2
    if (isPrime(n)) {
        primeCount++
    }
}
def stop = System.nanoTime()
println primeCount
println "Result: " + n
println "Time taken: " + (stop - start)/1e9