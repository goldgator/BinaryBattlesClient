"""Remove The Dupes! [EASY]"""
"""Make a Function that takes a list of items and removes duplicate items from the list"""
"""Ex: List("Kate", "Kate", "Lisa")       Output = ("Kate", "Lisa") """

"""Solution"""


def remove_dups(lst):
    return sorted(set(lst), key=lst.index)


# Test

print((remove_dups(['Jesse', 'Gali', 'Jesse'])))
