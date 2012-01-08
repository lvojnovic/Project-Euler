/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

//2*3*5*7*11*13*17*19=9699690
def start = System.nanoTime()
def step = 9699690
def result = step
while(1) {
    if (result%8 == 0 && result%9 == 0 && result%16 == 0) {
        break;
    }
    result+=step
}
def stop = System.nanoTime()
println "Result: " + result
println "Total time:" + (stop-start)/1e9

//or direct solution:
result = 2*2*2*2*3*3*5*7*11*13*17*19
println "Direct solution: " + result