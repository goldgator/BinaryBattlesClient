"""Date Formatting [Medium]"""
"""Create a function that takes a date formatted as MM/DD/YYYY and convert to YYYYDDMM"""
"""Ex: "02/05/2001" --> "20010502"""""

"""Solution"""


def format_date(date):
    m, d, y = date.split('/')
    return ''.join((y, d, m))


# Test
print(format_date("02/05/2001"))
