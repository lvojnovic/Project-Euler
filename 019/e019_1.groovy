/*
    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, 
    but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the 
twentieth century (1 Jan 1901 to 31 Dec 2000)?

*/

def count = 0
def sundayDate = Date.parse('dd.MM.yyyy', '06.01.1901')
def lastDate = Date.parse('dd.MM.yyyy', '31.12.2000')
while (sundayDate <= lastDate) {
    sundayDate += 7
    if (sundayDate.format('dd') == '01') {
        count ++
    }
}

count
