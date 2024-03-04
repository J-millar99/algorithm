S = input()
result = int(S[0])

for i in range(1, len(S)):
    n = int(S[i])
    if n <= 1 or result <= 1:
        result += n
    else:
        result *= n

print(result)
