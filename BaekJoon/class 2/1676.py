def factorial(num):
    if num <= 1:
        return 1
    sum = num
    for i in range(1, num):
        sum *= i
    return sum

n = int(input())
string = str(factorial(n))

l1 = len(string)
l2 = len(string.rstrip('0'))

print(l1 - l2)