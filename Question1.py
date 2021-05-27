

"""Greeting Name! [Easy]"""
"""Code a Function that takes a name(string) and adds a greeting"""
"""Ex: Input("Danny") --> Output = "Hey Danny!"  """

"""Solution"""


def hello_name(name):
    return "Hello {}!".format(name)


# Test
print(hello_name("Danny"))
print(hello_name("Gali"))
print(hello_name("Jesse"))