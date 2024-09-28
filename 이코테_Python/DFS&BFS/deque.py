from collections import deque

# d1 = deque(1, 2)      # Error
d1 = deque((1, 2))      # deque([1, 2])
d2 = deque([1, 2])      # deque([1, 2])

d3 = deque([(1, 2)])    # deque([(1, 2)])
d4 = deque(([1, 2]))    # deque([1, 2])

d5 = deque()
d5.append(1)
d5.append(2)            deque([1, 2])
print(d1, d2, d3, d4, d5)