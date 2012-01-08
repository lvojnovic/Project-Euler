/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

//1.
def start = System.nanoTime()
def sum = 0
(1..1000).step(1) { n ->
    if (n%3 == 0 || n%5 == 0) {
        sum += n
    }
}
def stop = System.nanoTime()
println "Direct approach: " + sum
println "Time taken: " + (stop-start)/1e9

//2. sum(x%5) + sum(x%3) - sum(x%15)
start = System.nanoTime()
sum = 0
(3..1000).step(3) { n ->
    sum+=n
}
(5..1000).step(5) { n ->
    sum+=n
}
(15..1000).step(15) { n->
    sum-=n
}

stop = System.nanoTime()
println "Second approach: " + sum
println "Time taken: " + (stop-start)/1e9