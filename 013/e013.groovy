/**
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
-> numbers are in the 'numbers' file in this directory

Solution:
Sum only first 11 digits of every number
Use doubles to simplify the code
Show only 10 first digits of the result
**/


def numbers = new File('numbers')

BigDecimal sum = 0
numbers.eachLine { wholeNumber ->
     sum += wholeNumber[0..10].toBigDecimal()
}

sum.toString()[0..9]