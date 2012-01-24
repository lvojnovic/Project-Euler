/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a2 + b2 = c2

For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

*/

import java.lang.Math

def start = System.nanoTime()
def result = null
for(i=1;i<997;i++) {
    for(j=i+1;j<998-i;j++) {
        def k = 1000-i-j;
        if (Math.pow(k,2) == Math.pow(i,2) + Math.pow(j,2)) {
            result = i*j*k
            break
        }
    }
    if(result) break
}
def stop = System.nanoTime()
println "Result: " + result
println "Time taken: " + (stop-start)/1e9 + " sec"