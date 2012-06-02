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

def days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']

def monthDays = [31,28,31,30,31,30,31,31,30,31,30,31]

def sundays = 0
def currentDay = 1
for (year in 1901..2000) {
    for (month in 0..11) {
        if (days[currentDay] == 'Sunday') {
            sundays++
        }
    
        if (month == 1 && year%4 == 0 && (year%100!=0 || year%400==0)) {
            currentDay = (currentDay + 1) % 7
        }
        
        currentDay = (currentDay + monthDays[month]) % 7
    }
}

sundays