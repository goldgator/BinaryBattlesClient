import datetime

"""More Dates??! [HARD]"""
"""Create a Function that when given a date "MM/DD/YYYY" it returns a day"""
""" EX: Input("12/07/2016) --> "Wednesday    Input("09/04/2016) --> "Sunday" """
""" Imports?    "datetime """

"""Solution"""


def get_day(day):
    m, d, y = [int(i) for i in day.split('/')]
    days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
    return days[datetime.date(y, m, d).weekday()]

# Test


print(get_day("09/05/2016"))
