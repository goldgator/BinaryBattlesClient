"""Lets Make a Calculator! [Medium]"""
"""Make a Class called "Calculator" and add methods for add() subtract() multiply() and divide()"""
""" Ex. calculator.add(10, 10) --> 20           calculator.subtract(10, 5) --> 5    """

"""Solution"""


class Calculator:
    #  methods to add(), subtract(), multiply() and divide()
    def add(self, a, b):
        return a + b

    def subtract(self, a, b):
        return a - b

    def multiply(self, a, b):
        return a * b

    def divide(self, a, b):
        return a / b


# Test
calculator = Calculator()

print(calculator.add(10, 5))
print(calculator.subtract(10, 5))
print(calculator.multiply(10, 5))
print(calculator.divide(10, 5))
